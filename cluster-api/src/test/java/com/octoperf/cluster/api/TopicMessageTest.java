package com.octoperf.cluster.api;

import com.google.common.testing.NullPointerTester;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static com.google.common.testing.NullPointerTester.Visibility.PACKAGE;
import static nl.jqno.equalsverifier.Warning.REFERENCE_EQUALITY;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class TopicMessageTest {
  private static final String HELLO_WORLD = "Hello world!";

  @Test
  public void shouldPassEqualsVerifier() {
    EqualsVerifier.forClass(TopicMessage.class).suppress(REFERENCE_EQUALITY).verify();
  }

  @Test
  public void shouldPassNullPointerTester() {
    new NullPointerTester().testConstructors(TopicMessage.class, PACKAGE);
  }

  @Test
  public void shouldCreate() {
    assertNotNull(newInstance());
  }

  @Test
  public void shouldHaveNonStandardToString() {
    assertFalse(newInstance().toString().contains("@"));
  }

  public static TopicMessage<String> newInstance() {
    return new TopicMessage<>(HELLO_WORLD);
  }
}
