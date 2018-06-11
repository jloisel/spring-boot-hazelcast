package com.octoperf.cluster.api;

public interface ClusteringService {

  boolean isLeader();

  <K, V> ClusteredMap<K, V> getMap(String id);

  <T> ClusteredQueue<T> getQueue(String id);

  <T> ClusteredTopic<T> getReliableTopic(String id);

  ClusteredAtomicLong getAtomicLong(String id);

  ClusteredLock getLock(String id);
}
