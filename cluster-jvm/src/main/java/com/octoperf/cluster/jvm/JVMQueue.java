package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.AbstractClusteredQueue;
import com.octoperf.cluster.api.DestroyableObject;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class JVMQueue<T> extends AbstractClusteredQueue<T> {
  @NonNull
  DestroyableObject onDestroy;

  BlockingQueue<T> queue = new LinkedBlockingQueue<>();

  @Override
  public void destroy() {
    onDestroy.destroy();
  }

  @Override
  protected BlockingQueue<T> queue() {
    return queue;
  }
}
