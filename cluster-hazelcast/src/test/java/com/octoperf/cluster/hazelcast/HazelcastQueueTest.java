//package com.octoperf.cluster.hazelcast;
//
//import com.octoperf.cluster.api.AbstractClusteredQueueTest;
//import com.octoperf.cluster.api.ClusteredQueue;
//import com.octoperf.cluster.api.ClusteringService;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class HazelcastQueueTest extends AbstractClusteredQueueTest {
//  @Autowired
//  ClusteringService service;
//
//  @Override
//  protected ClusteredQueue<String> newService() {
//    return service.getQueue("Test");
//  }
//}
