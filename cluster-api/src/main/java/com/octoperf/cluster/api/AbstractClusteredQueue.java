package com.octoperf.cluster.api;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class AbstractClusteredQueue<T> implements ClusteredQueue<T> {

  @Override
  public final void put(final T elt) throws InterruptedException {
    queue().put(elt);
  }

  @Override
  public final int drainTo(final List<T> list) {
    return queue().drainTo(list);
  }

  @Override
  public final int size() {
    return queue().size();
  }

  @Override
  public final T poll(final long timeout, final TimeUnit unit) throws InterruptedException {
    return queue().poll(timeout, unit);
  }

  protected abstract BlockingQueue<T> queue();
}
