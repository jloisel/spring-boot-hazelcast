package com.octoperf.cluster.jvm;

import com.octoperf.cluster.api.AbstractClusteredMapTest;
import com.octoperf.cluster.api.ClusteredMap;
import com.octoperf.cluster.api.DestroyableObject;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class JVMMapTest extends AbstractClusteredMapTest<String> {
  @Mock
  DestroyableObject destroyable;

  @Override
  protected ClusteredMap<String, String> newService() {
    return new JVMMap<>(destroyable);
  }

  @Override
  public void shouldDestroy() {
    super.shouldDestroy();
    verify(destroyable).destroy();
  }

  @Override
  protected String newValue() {
    return "value";
  }
}
