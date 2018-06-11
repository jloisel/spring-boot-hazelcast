package com.octoperf.cluster.hazelcast;

import com.google.common.collect.Iterables;
import com.hazelcast.core.Cluster;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.ILock;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Member;
import com.octoperf.cluster.api.ClusteredAtomicLong;
import com.octoperf.cluster.api.ClusteredLock;
import com.octoperf.cluster.api.ClusteredMap;
import com.octoperf.cluster.api.ClusteredQueue;
import com.octoperf.cluster.api.ClusteredTopic;
import com.octoperf.cluster.api.ClusteringService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access=PACKAGE)
@FieldDefaults(level=PRIVATE, makeFinal=true)
final class HazelcastClusteringService implements ClusteringService {
  @NonNull
  HazelcastInstance hz;
  @NonNull
  HZQuorumListener quorum;

  @Override
  public boolean isLeader() {
    final Cluster cluster = hz.getCluster();
    final Member leader = Iterables.getFirst(cluster.getMembers(), cluster.getLocalMember());
    return leader.localMember() && quorum.isQuorum();
  }

  @Override
  public <K, V> ClusteredMap<K, V> getMap(final String id) {
    final IMap<K, V> map = hz.getMap(id);
    return new HazelcastMap<>(map);
  }

  @Override
  public <T> ClusteredQueue<T> getQueue(final String id) {
    final IQueue<T> queue = hz.getQueue(id);
    return new HazelcastQueue<>(queue);
  }

  @Override
  public <T> ClusteredTopic<T> getReliableTopic(final String id) {
    final ITopic<T> topic = hz.getReliableTopic(id);
    return new HazelcastTopic<>(topic);
  }

  @Override
  public ClusteredAtomicLong getAtomicLong(final String id) {
    final IAtomicLong atomic = hz.getAtomicLong(id);
    return new HazelcastAtomicLong(atomic);
  }

  @Override
  public ClusteredLock getLock(final String id) {
    final ILock lock = hz.getLock(id);
    return new HazelcastLock(lock);
  }
}
