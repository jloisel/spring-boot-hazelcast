package com.octoperf.cluster.api;

import com.google.common.collect.ImmutableMap;
import com.google.common.testing.NullPointerTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.junit.Assert.assertEquals;

public abstract class AbstractClusteredMapTest<V> {

  private ClusteredMap<String, V> service;

  private V value;

  @Before
  public void before() {
    service = newService();
    value = newValue();
  }

  @Test
  public void shouldPutGet() {
    service.put("key", value);
    assertEquals(value, service.get("key").orElse(null));
  }

  @Test
  public void shouldPutRemove() {
    service.put("key", value);
    service.remove("key");
    assertEquals(Optional.empty(), service.get("key"));
  }

  @Test
  public void shouldCopyOf() {
    service.put("key", value);
    final Map<String, V> copyOf = service.copyOf();
    assertEquals(ImmutableMap.of("key", value), copyOf);
  }

  @Test
  public void shouldDestroy() {
    service.destroy();
  }

  @Test
  public void shouldPassNPETester() {
    new NullPointerTester().testConstructors(service.getClass(), PACKAGE);
  }

  @After
  public void after() {
    service.destroy();
  }

  protected abstract ClusteredMap<String, V> newService();

  protected abstract V newValue();
}
