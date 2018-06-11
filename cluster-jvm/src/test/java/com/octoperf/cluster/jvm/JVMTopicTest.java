package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.AbstractClusteredTopicTest;
import com.octoperf.cluster.api.ClusteredTopic;

public class JVMTopicTest extends AbstractClusteredTopicTest {

  @Override
  protected ClusteredTopic<String> newService() {
    return new JVMTopic<>(() -> {});
  }
}
