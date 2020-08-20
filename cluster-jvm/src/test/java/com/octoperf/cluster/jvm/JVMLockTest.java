package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.AbstractClusteredLockTest;
import com.octoperf.cluster.api.ClusteredLock;

public class JVMLockTest extends AbstractClusteredLockTest {

  @Override
  protected ClusteredLock newService() {
    return new JVMLock();
  }
}
