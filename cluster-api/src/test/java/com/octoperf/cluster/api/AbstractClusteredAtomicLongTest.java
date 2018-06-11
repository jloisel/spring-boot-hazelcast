package com.octoperf.cluster.api;

import com.google.common.testing.NullPointerTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertEquals;

public abstract class AbstractClusteredAtomicLongTest {

  private ClusteredAtomicLong service;

  @Before
  public void before() {
    service = newService();
  }

  @Test
  public void shouldIncrementAndGet() {
    assertEquals(1, service.incrementAndGet());
    assertEquals(2, service.incrementAndGet());
  }

  @Test
  public void shouldGet() {
    assertEquals(1, service.incrementAndGet());
    assertEquals(1, service.get());
  }

  @Test
  public void shouldPassNPETester() {
    new NullPointerTester().testConstructors(service.getClass(), PACKAGE);
  }

  @After
  public void after() {
    service.destroy();
  }

  protected abstract ClusteredAtomicLong newService();
}
