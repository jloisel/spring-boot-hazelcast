package com.octoperf.cluster.hazelcast;

import com.hazelcast.config.Config;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.assertNotNull;

public class HazelcastConfigTest {

  private final HazelcastConfig config = new HazelcastConfig();

  @Test
  public void shouldAutowire() throws UnknownHostException {
    Config localhost = config.config(new HazelcastQuorumListener(1), "localhost");
    assertNotNull(localhost);
    localhost = config.config(new HazelcastQuorumListener(2), "localhost, 127.0.0.1");
    assertNotNull(localhost);
  }
}

