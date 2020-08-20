//package com.octoperf.cluster.hazelcast;
//
//import com.google.common.testing.NullPointerTester;
//import com.hazelcast.core.Cluster;
//import com.octoperf.cluster.api.ClusteringService;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.actuate.health.Health;
//
//import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.springframework.boot.actuate.health.Status.OUT_OF_SERVICE;
//import static org.springframework.boot.actuate.health.Status.UP;
//
//@RunWith(MockitoJUnitRunner.class)
//public class HazelcastHealthIndicatorTest {
//
//  @Mock
//  ClusteringService cluster;
//  @Mock
//  HZQuorumListener quorum;
//  @Mock
//  Cluster hz;
//
//  private HazelcastHealthIndicator service;
//
//  @Before
//  public void before() {
//    service = new HazelcastHealthIndicator(cluster, quorum, hz);
//  }
//
//  @Test
//  public void shouldReturnUp() {
//    when(quorum.isQuorum()).thenReturn(true);
//    final Health health = service.health();
//    assertEquals(UP, health.getStatus());
//  }
//
//  @Test
//  public void shouldReturnOutOfService() {
//    when(quorum.isQuorum()).thenReturn(false);
//    final Health health = service.health();
//    assertEquals(OUT_OF_SERVICE, health.getStatus());
//  }
//
//  @Test
//  public void shouldPassNullPointerTester() {
//    new NullPointerTester().testConstructors(service.getClass(), PACKAGE);
//  }
//
//}
