package com.octoperf.cluster.hazelcast;

import com.hazelcast.core.IMap;
import com.octoperf.cluster.api.ClusteredMap;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class HazelcastMap<K, V> implements ClusteredMap<K, V> {
  @NonNull
  IMap<K, V> map;

  @Override
  public Optional<V> get(final K key) {
    return ofNullable(map.get(key));
  }

  @Override
  public void put(final K key, final V value) {
    map.set(key, value);
  }

  @Override
  public void remove(final K key) {
    map.delete(key);
  }

  @Override
  public Map<K, V> copyOf() {
    return new HashMap<>(map);
  }

  @Override
  public void destroy() {
    map.destroy();
  }
}
