package com.octoperf.cluster.hazelcast;

import com.hazelcast.core.Cluster;
import com.octoperf.cluster.api.ClusteringService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;
import static org.springframework.boot.actuate.health.Status.OUT_OF_SERVICE;
import static org.springframework.boot.actuate.health.Status.UP;

@AllArgsConstructor(access= PACKAGE)
@FieldDefaults(level=PRIVATE, makeFinal=true)
final class HazelcastHealthIndicator extends AbstractHealthIndicator {
  @NonNull
  ClusteringService cluster;
  @NonNull
  HZQuorumListener quorum;
  @NonNull
  Cluster hz;

  @Override
  protected void doHealthCheck(final Health.Builder builder) {
    builder.withDetail("isLeader", cluster.isLeader());
    builder.withDetail("isQuorum", quorum.isQuorum());
    builder.withDetail("members", hz.getMembers().toString());
    builder.status(quorum.isQuorum() ? UP : OUT_OF_SERVICE);
  }
}
