//package com.octoperf.cluster.hazelcast;
//
//import com.hazelcast.core.Message;
//import com.octoperf.cluster.api.AbstractClusteredTopicTest;
//import com.octoperf.cluster.api.ClusteredTopic;
//import com.octoperf.cluster.api.ClusteringService;
//import com.octoperf.cluster.api.TopicMessage;
//import com.octoperf.cluster.api.TopicMessageListener;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
//public class HazelcastTopicTest extends AbstractClusteredTopicTest {
//  @Autowired
//  ClusteringService service;
//  @MockBean
//  Message<String> message;
//  @MockBean
//  TopicMessageListener<String> listener;
//
//  @Test
//  public void shouldOnMessage() {
//    when(message.getMessageObject()).thenReturn(HELLO_WORLD);
//    final HazelcastTopic<String> topic = (HazelcastTopic<String>) this.newService();
//    topic.register(listener);
//    topic.onMessage(message);
//    verify(listener).onMessage(new TopicMessage<>(HELLO_WORLD));
//  }
//
//  @Override
//  protected ClusteredTopic<String> newService() {
//    return service.getReliableTopic("Test");
//  }
//}
