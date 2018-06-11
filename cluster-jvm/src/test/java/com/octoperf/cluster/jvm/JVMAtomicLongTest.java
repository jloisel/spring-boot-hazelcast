package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.AbstractClusteredAtomicLongTest;
import com.octoperf.cluster.api.ClusteredAtomicLong;

public class JVMAtomicLongTest extends AbstractClusteredAtomicLongTest {

  @Override
  protected ClusteredAtomicLong newService() {
    return new JVMAtomicLong(() -> {});
  }
}
