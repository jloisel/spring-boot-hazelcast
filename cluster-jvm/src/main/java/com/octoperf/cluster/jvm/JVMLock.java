package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.ClusteredLock;
import com.octoperf.cluster.api.DestroyableObject;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.locks.ReentrantLock;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class JVMLock implements ClusteredLock {
  @NonNull
  DestroyableObject onDestroy;

  ReentrantLock lock = new ReentrantLock();

  @Override
  public void lock() {
    lock.lock();
  }

  @Override
  public void unlock() {
    lock.unlock();
  }

  @Override
  public void destroy() {
    onDestroy.destroy();
  }
}
