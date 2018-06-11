package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.ClusteredMap;
import com.octoperf.cluster.api.DestroyableObject;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PUBLIC;

@AllArgsConstructor(access = PUBLIC)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class JVMMap<K, V> implements ClusteredMap<K, V> {
  @NonNull
  DestroyableObject onDestroy;

  ConcurrentMap<K, V> map = new ConcurrentHashMap<>();

  @Override
  public Optional<V> get(final K key) {
    return ofNullable(map.get(key));
  }

  @Override
  public void put(final K key, final V value) {
    map.put(key, value);
  }

  @Override
  public void remove(final K key) {
    map.remove(key);
  }

  @Override
  public Map<K, V> copyOf() {
    return new HashMap<>(map);
  }

  @Override
  public void destroy() {
    onDestroy.destroy();
  }
}
