//package com.octoperf.cluster.hazelcast;
//
//import com.google.common.collect.ImmutableSet;
//import com.hazelcast.core.Cluster;
//import com.hazelcast.core.HazelcastInstance;
//import com.hazelcast.core.IAtomicLong;
//import com.hazelcast.core.ILock;
//import com.hazelcast.core.IMap;
//import com.hazelcast.core.IQueue;
//import com.hazelcast.core.ITopic;
//import com.hazelcast.core.Member;
//import com.hazelcast.core.MembershipEvent;
//import com.octoperf.cluster.api.AbstractClusteringServiceTest;
//import com.octoperf.cluster.api.ClusteringService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class HazelcastClusteringServiceTest extends AbstractClusteringServiceTest {
//
//  final HazelcastQuorumListener listener = new HazelcastQuorumListener(1);
//
//  @Mock
//  HazelcastInstance hz;
//  @Mock
//  Cluster cluster;
//  @Mock
//  Member local;
//  @Mock
//  MembershipEvent event;
//
//  @Before
//  public void before() {
//    when(hz.getCluster()).thenReturn(cluster);
//    when(hz.getQueue(anyString())).thenAnswer(args -> mock(IQueue.class));
//    when(hz.getAtomicLong(anyString())).thenAnswer(args -> mock(IAtomicLong.class));
//    when(hz.getReliableTopic(anyString())).thenAnswer(args -> mock(ITopic.class));
//    when(hz.getLock(anyString())).thenAnswer(args -> mock(ILock.class));
//    when(hz.getMap(anyString())).thenAnswer(args -> mock(IMap.class));
//    when(cluster.getMembers()).thenReturn(ImmutableSet.of(local));
//    when(cluster.getLocalMember()).thenReturn(local);
//    when(local.localMember()).thenReturn(true);
//  }
//
//  @Test
//  public void shouldNotBeLeader() {
//    final ClusteringService service = newService();
//
//    when(event.getMembers()).thenReturn(ImmutableSet.of());
//    listener.memberRemoved(event);
//    assertFalse(service.isLeader());
//
//    when(event.getMembers()).thenReturn(ImmutableSet.of(local));
//    listener.memberAdded(event);
//    assertTrue(service.isLeader());
//
//    when(local.localMember()).thenReturn(false);
//    assertFalse(service.isLeader());
//
//    when(local.localMember()).thenReturn(true);
//    assertTrue(service.isLeader());
//  }
//
//  @Override
//  protected ClusteringService newService() {
//    return new HazelcastClusteringService(hz, listener);
//  }
//
//}
