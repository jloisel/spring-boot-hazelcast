package com.octoperf.cluster.api;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ClusteredQueue<T> extends DestroyableObject {

  void put(T elt) throws InterruptedException;

  int drainTo(List<T> list);

  int size();

  T poll(long timeout, TimeUnit unit) throws InterruptedException;
}
