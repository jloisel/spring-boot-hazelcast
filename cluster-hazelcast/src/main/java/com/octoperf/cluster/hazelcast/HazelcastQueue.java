package com.octoperf.cluster.hazelcast;

import com.hazelcast.core.IQueue;
import com.octoperf.cluster.api.AbstractClusteredQueue;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.BlockingQueue;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class HazelcastQueue<T> extends AbstractClusteredQueue<T> {
  @NonNull
  IQueue<T> queue;

  @Override
  public void destroy() {
    queue.destroy();
  }

  @Override
  protected BlockingQueue<T> queue() {
    return queue;
  }
}
