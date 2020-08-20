//package com.octoperf.cluster.hazelcast;
//
//import com.google.common.collect.ImmutableSet;
//import com.hazelcast.core.Member;
//import com.hazelcast.core.MembershipEvent;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class HazelcastQuorumListenerTest {
//
//  @Mock
//  MembershipEvent event;
//  @Mock
//  Member first;
//  @Mock
//  Member second;
//
//  private HazelcastQuorumListener listener;
//
//  @Test
//  public void shouldBeQuorum() {
//    listener = new HazelcastQuorumListener(1);
//    assertTrue(listener.isQuorum());
//  }
//
//  @Test
//  public void shouldBeQuorum2() {
//    listener = new HazelcastQuorumListener(2);
//    assertFalse(listener.isQuorum());
//  }
//
//  @Test
//  public void shouldNotBeLeader() {
//    listener = new HazelcastQuorumListener(1);
//    when(event.getMembers()).thenReturn(ImmutableSet.of());
//    listener.memberRemoved(event);
//    assertFalse(listener.isQuorum());
//
//    when(event.getMembers()).thenReturn(ImmutableSet.of(first));
//    listener.memberAdded(event);
//    assertTrue(listener.isQuorum());
//  }
//
//  @Test
//  public void shouldBeQuorum3() {
//    listener = new HazelcastQuorumListener(2);
//    assertFalse(listener.isQuorum());
//    when(event.getMembers()).thenReturn(ImmutableSet.of(first, second));
//    listener.memberAdded(event);
//    assertTrue(listener.isQuorum());
//  }
//}
