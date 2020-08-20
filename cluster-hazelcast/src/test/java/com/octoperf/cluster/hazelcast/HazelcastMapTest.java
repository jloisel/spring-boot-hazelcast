//package com.octoperf.cluster.hazelcast;
//
//import com.octoperf.cluster.api.AbstractClusteredMapTest;
//import com.octoperf.cluster.api.ClusteredMap;
//import com.octoperf.cluster.api.ClusteringService;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class HazelcastMapTest extends AbstractClusteredMapTest<String> {
//  @Autowired
//  ClusteringService service;
//
//  @Override
//  protected ClusteredMap<String, String> newService() {
//    return service.getMap("map");
//  }
//
//  @Override
//  protected String newValue() {
//    return "value";
//  }
//}
