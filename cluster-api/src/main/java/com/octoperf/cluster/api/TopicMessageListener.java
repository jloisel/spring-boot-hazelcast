package com.octoperf.cluster.api;

@FunctionalInterface
public interface TopicMessageListener<T> {

  void onMessage(TopicMessage<T> message);
}
