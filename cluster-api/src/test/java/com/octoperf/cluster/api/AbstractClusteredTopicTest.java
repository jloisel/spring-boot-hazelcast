package com.octoperf.cluster.api;

import com.google.common.testing.NullPointerTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static org.mockito.Mockito.mock;

public abstract class AbstractClusteredTopicTest {
  protected static final String HELLO_WORLD = "Hello World!";

  private ClusteredTopic<String> service;

  @Before
  public void before() {
    service = newService();
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldRegisterAndPublish() {
    final TopicMessageListener<String> listener = mock(TopicMessageListener.class);
    service.register(listener);
    service.publish(HELLO_WORLD);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void shouldUnregisterAndPublish() {
    final TopicMessageListener<String> listener = mock(TopicMessageListener.class);
    service.register(listener);
    service.publish(HELLO_WORLD);
    service.unregister(listener);
    service.publish(HELLO_WORLD);
  }

  @Test
  public void shouldPassNPETester() {
    new NullPointerTester().testConstructors(service.getClass(), PACKAGE);
  }

  @After
  public void after() {
    service.destroy();
  }

  protected abstract ClusteredTopic<String> newService();
}
