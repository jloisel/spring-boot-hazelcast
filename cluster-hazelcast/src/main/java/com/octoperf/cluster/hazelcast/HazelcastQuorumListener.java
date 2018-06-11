package com.octoperf.cluster.hazelcast;

import com.hazelcast.core.MembershipAdapter;
import com.hazelcast.core.MembershipEvent;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.atomic.AtomicBoolean;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
final class HazelcastQuorumListener extends MembershipAdapter implements HZQuorumListener {
  int quorum;
  AtomicBoolean isQuorum;

  HazelcastQuorumListener(final int quorum) {
    super();
    this.quorum = quorum;
    this.isQuorum = new AtomicBoolean(quorum == 1);
  }

  @Override
  public void memberAdded(final MembershipEvent e) {
    memberRemoved(e);
  }

  @Override
  public void memberRemoved(final MembershipEvent e) {
    isQuorum.set(e.getMembers().size() >= quorum);
  }

  @Override
  public boolean isQuorum() {
    return isQuorum.get();
  }
}
