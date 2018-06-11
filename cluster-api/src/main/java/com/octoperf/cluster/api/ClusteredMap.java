package com.octoperf.cluster.api;

import java.util.Map;
import java.util.Optional;

public interface ClusteredMap<K, V> extends DestroyableObject {

  Optional<V> get(final K key);

  void put(final K key, final V value);

  void remove(final K key);

  Map<K, V> copyOf();
}
