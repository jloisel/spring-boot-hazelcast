package com.octoperf.cluster.hazelcast;

import com.hazelcast.core.ILock;
import com.octoperf.cluster.api.ClusteredLock;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class HazelcastLock implements ClusteredLock {
  @NonNull
  ILock lock;

  @Override
  public void destroy() {
    lock.destroy();
  }

  @Override
  public void lock() {
    lock.lock();
  }

  @Override
  public void unlock() {
    lock.unlock();
  }
}
