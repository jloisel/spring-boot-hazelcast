package com.octoperf.cluster.api;

import com.google.common.collect.ImmutableList;
import com.google.common.testing.NullPointerTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertEquals;

public abstract class AbstractClusteredQueueTest {

  private static final String HELLO_WORLD = "Hello World!";

  private ClusteredQueue<String> service;

  @Before
  public void before() {
    service = newService();
  }

  @Test
  public void shouldAdd() throws InterruptedException {
    service.put(HELLO_WORLD);
    assertEquals(1, service.size());
  }

  @Test
  public void shouldHaveZeroSize() {
    assertEquals(0, service.size());
  }

  @Test
  public void shouldDrainTo() throws InterruptedException {
    service.put(HELLO_WORLD);
    assertEquals(1, service.size());

    final List<String> list = new ArrayList<>();
    service.drainTo(list);
    assertEquals(ImmutableList.of(HELLO_WORLD), list);
    assertEquals(0, service.size());
  }

  @Test
  public void shouldPoll() throws InterruptedException {
    service.put(HELLO_WORLD);
    assertEquals(1, service.size());

    final String polled = service.poll(0, SECONDS);
    assertEquals(HELLO_WORLD, polled);
  }

  @Test
  public void shouldPassNPETester() {
    new NullPointerTester().testConstructors(service.getClass(), PACKAGE);
  }

  @After
  public void after() {
    service.destroy();
  }

  protected abstract ClusteredQueue<String> newService();
}
