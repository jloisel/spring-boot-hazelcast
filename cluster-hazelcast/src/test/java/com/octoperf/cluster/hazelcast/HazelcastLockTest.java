//package com.octoperf.cluster.hazelcast;
//
//import com.octoperf.cluster.api.AbstractClusteredLockTest;
//import com.octoperf.cluster.api.ClusteredLock;
//import com.octoperf.cluster.api.ClusteringService;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class HazelcastLockTest extends AbstractClusteredLockTest {
//  @Autowired
//  ClusteringService service;
//
//  @Override
//  protected ClusteredLock newService() {
//    return service.getLock("Test");
//  }
//}
