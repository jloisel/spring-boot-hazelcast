package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.ClusteredAtomicLong;
import com.octoperf.cluster.api.DestroyableObject;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.atomic.AtomicLong;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class JVMAtomicLong implements ClusteredAtomicLong {
  @NonNull
  DestroyableObject onDestroy;
  AtomicLong atomic = new AtomicLong();

  @Override
  public void destroy() {
    onDestroy.destroy();
  }

  @Override
  public long incrementAndGet() {
    return atomic.incrementAndGet();
  }

  @Override
  public long get() {
    return atomic.get();
  }
}
