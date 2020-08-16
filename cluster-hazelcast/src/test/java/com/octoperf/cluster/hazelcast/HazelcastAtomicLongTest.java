//package com.octoperf.cluster.hazelcast;
//
//import com.octoperf.cluster.api.AbstractClusteredAtomicLongTest;
//import com.octoperf.cluster.api.ClusteredAtomicLong;
//import com.octoperf.cluster.api.ClusteringService;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class HazelcastAtomicLongTest extends AbstractClusteredAtomicLongTest {
//  @Autowired
//  ClusteringService service;
//
//  @Override
//  protected ClusteredAtomicLong newService() {
//    return service.getAtomicLong("Test");
//  }
//}
