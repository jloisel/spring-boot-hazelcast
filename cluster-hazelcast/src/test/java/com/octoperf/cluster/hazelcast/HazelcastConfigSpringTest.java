package com.octoperf.cluster.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.octoperf.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class HazelcastConfigSpringTest {

  @Autowired
  private HazelcastInstance instance;

  @Test
  public void shouldAutowire() {
    assertNotNull(instance);
  }

}
