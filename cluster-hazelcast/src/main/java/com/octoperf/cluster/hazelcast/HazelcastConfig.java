package com.octoperf.cluster.hazelcast;

import com.google.common.base.MoreObjects;
import com.google.common.base.Splitter;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.ListenerConfig;
import com.hazelcast.config.MulticastConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.config.TcpIpConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MembershipListener;
import com.octoperf.cluster.api.ClusteringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Configuration
@ConditionalOnProperty(name = "clustering.driver", havingValue = "hazelcast")
class HazelcastConfig {
  private static final Splitter COMA = Splitter.on(',').trimResults();

  @Bean
  HazelcastQuorumListener membershipListener(@Value("${clustering.hazelcast.quorum:1}") final int quorum) {
    return new HazelcastQuorumListener(quorum);
  }

  @Bean
  Config config(
    final MembershipListener listener,
    @Value("${clustering.hazelcast.members:127.0.0.1}") final String members) throws UnknownHostException {
    final Config config = new Config();

    final NetworkConfig network = config.getNetworkConfig();
    
    final JoinConfig join = network.getJoin();
    final MulticastConfig multicast = join.getMulticastConfig();
    multicast.setEnabled(false);
    
    final TcpIpConfig tcpIp = join.getTcpIpConfig();

    tcpIp.setEnabled(true);
    for(final String member : COMA.splitToList(members)) {
      final InetAddress[] addresses = MoreObjects.firstNonNull(
        InetAddress.getAllByName(member),
        new InetAddress[0]);
      for (final InetAddress addr : addresses) {
        final String hostAddress = addr.getHostAddress();
        tcpIp.addMember(hostAddress);
        log.info("[Hazelcast] New Member: " + hostAddress);
      }
    }

    return config.addListenerConfig(new ListenerConfig(listener));
  }

  @Bean
  ClusteringService clusteringService(final HazelcastInstance hz, final HZQuorumListener listener) {
    return new HazelcastClusteringService(hz, listener);
  }

  @Bean
  HazelcastHealthIndicator clusterHealthIndicator(
    final ClusteringService cluster,
    final HZQuorumListener listener,
    final HazelcastInstance hz) {
    return new HazelcastHealthIndicator(cluster, listener, hz.getCluster());
  }
}
