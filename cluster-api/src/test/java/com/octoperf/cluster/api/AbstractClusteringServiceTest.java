package com.octoperf.cluster.api;

import com.google.common.testing.NullPointerTester;
import org.junit.Test;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public abstract class AbstractClusteringServiceTest {

  public static final String TEST = "Test";

  @Test
  public void shouldReturnIsLeader() {
    final ClusteringService service = newService();
    final boolean isLeader = service.isLeader();
    assertTrue(isLeader);
  }

  @Test
  public void shouldReturnLock() {
    final ClusteringService service = newService();
    final ClusteredLock lock = service.getLock(TEST);
    assertNotNull(lock);
    lock.destroy();
    assertNotSame(lock, service.getLock(TEST));
  }

  @Test
  public void shouldReturnQueue() {
    final ClusteringService service = newService();
    final ClusteredQueue<String> queue = service.getQueue(TEST);
    assertNotNull(queue);
    queue.destroy();
    assertNotSame(queue, service.getQueue(TEST));
  }

  @Test
  public void shouldReturnAtomicLong() {
    final ClusteringService service = newService();
    final ClusteredAtomicLong atomicLong = service.getAtomicLong(TEST);
    assertNotNull(atomicLong);
    atomicLong.destroy();
    assertNotSame(atomicLong, service.getAtomicLong(TEST));
  }

  @Test
  public void shouldReturnTopic() {
    final ClusteringService service = newService();
    final ClusteredTopic<String> topic = service.getReliableTopic(TEST);
    assertNotNull(topic);
    topic.destroy();
    assertNotSame(topic, service.getReliableTopic(TEST));
  }

  @Test
  public void shouldReturnMap() {
    final ClusteringService service = newService();
    final ClusteredMap<Object, Object> map = service.getMap(TEST);
    assertNotNull(map);
    map.destroy();
    assertNotSame(map, service.getMap(TEST));
  }

  @Test
  public void shouldPassNPETester() {
    final ClusteringService service = newService();
    new NullPointerTester().testConstructors(service.getClass(), PACKAGE);
  }

  protected abstract ClusteringService newService();
}
