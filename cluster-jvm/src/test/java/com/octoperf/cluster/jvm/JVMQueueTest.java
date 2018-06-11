package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.AbstractClusteredQueueTest;
import com.octoperf.cluster.api.ClusteredQueue;

public class JVMQueueTest extends AbstractClusteredQueueTest {

  @Override
  protected ClusteredQueue<String> newService() {
    return new JVMQueue<>(() -> {});
  }
}
