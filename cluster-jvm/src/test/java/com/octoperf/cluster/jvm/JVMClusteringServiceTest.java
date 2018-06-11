package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.AbstractClusteringServiceTest;
import com.octoperf.cluster.api.ClusteringService;

public class JVMClusteringServiceTest extends AbstractClusteringServiceTest {

  @Override
  protected ClusteringService newService() {
    return new JVMClusteringService();
  }
}
