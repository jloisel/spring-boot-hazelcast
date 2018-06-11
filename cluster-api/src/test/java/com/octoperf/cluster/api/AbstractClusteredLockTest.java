package com.octoperf.cluster.api;

import com.google.common.testing.NullPointerTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;

public abstract class AbstractClusteredLockTest {
  private ClusteredLock service;

  @Before
  public void before() {
    service = newService();
  }

  @Test
  public void shouldLock() throws InterruptedException {
    service.lock();
  }

  @Test
  public void shouldUnLock() throws InterruptedException {
    service.lock();
    service.unlock();
  }

  @Test
  public void shouldPassNPETester() {
    new NullPointerTester().testConstructors(service.getClass(), PACKAGE);
  }

  @After
  public void after() {
    service.destroy();
  }

  protected abstract ClusteredLock newService();
}
