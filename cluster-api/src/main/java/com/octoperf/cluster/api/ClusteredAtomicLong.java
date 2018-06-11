package com.octoperf.cluster.api;

public interface ClusteredAtomicLong extends DestroyableObject {

  long incrementAndGet();

  long get();
}
