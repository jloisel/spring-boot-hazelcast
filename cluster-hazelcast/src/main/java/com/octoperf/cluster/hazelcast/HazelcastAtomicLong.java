package com.octoperf.cluster.hazelcast;

import com.hazelcast.core.IAtomicLong;
import com.octoperf.cluster.api.ClusteredAtomicLong;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class HazelcastAtomicLong implements ClusteredAtomicLong {
  @NonNull
  IAtomicLong atomic;

  @Override
  public void destroy() {
    atomic.destroy();
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
