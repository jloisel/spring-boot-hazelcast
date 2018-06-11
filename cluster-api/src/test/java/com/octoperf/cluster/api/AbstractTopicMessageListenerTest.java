package com.octoperf.cluster.api;

import org.junit.Before;
import org.junit.Test;

public abstract class AbstractTopicMessageListenerTest {

  private static final String HELLO_WORLD = "Hello World!";

  private TopicMessageListener<String> service;

  @Before
  public void before() {
    service = newService();
  }

  @Test
  public void shouldOnMessage() {
    service.onMessage(new TopicMessage<>(HELLO_WORLD));
  }


  protected abstract TopicMessageListener<String> newService();
}
