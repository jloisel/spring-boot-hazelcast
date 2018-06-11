package com.octoperf.cluster.api;

import lombok.Value;

import static java.util.Objects.requireNonNull;

@Value
public class TopicMessage<T> {
  T value;

  public TopicMessage(final T value) {
    super();
    this.value = requireNonNull(value);
  }
}
