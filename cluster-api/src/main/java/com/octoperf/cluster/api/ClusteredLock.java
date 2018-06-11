package com.octoperf.cluster.api;

public interface ClusteredLock extends DestroyableObject {

  void lock();

  void unlock();
}
