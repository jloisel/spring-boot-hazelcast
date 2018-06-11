package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.ClusteredTopic;
import com.octoperf.cluster.api.DestroyableObject;
import com.octoperf.cluster.api.TopicMessage;
import com.octoperf.cluster.api.TopicMessageListener;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class JVMTopic<T> implements ClusteredTopic<T> {
  @NonNull
  DestroyableObject onDestroy;

  List<TopicMessageListener<T>> listeners = new CopyOnWriteArrayList<>();

  @Override
  public void destroy() {
    onDestroy.destroy();
  }

  @Override
  public void register(final TopicMessageListener<T> listener) {
    listeners.add(listener);
  }

  @Override
  public void unregister(TopicMessageListener<T> listener) {
    listeners.remove(listener);
  }

  @Override
  public void publish(final T s) {
    final TopicMessage<T> msg = new TopicMessage<>(s);
    listeners.forEach(listener -> listener.onMessage(msg));
  }
}
