package com.octoperf;

import com.octoperf.cluster.api.ClusteredMap;
import com.octoperf.cluster.api.ClusteringService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/cluster")
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
class ClusterController {
  private static final String MAP_ID = "map";

  @NonNull
  ClusteringService clustering;

  @GetMapping("/{key}")
  Optional<String> get(@PathVariable("key") final String key) {
    final ClusteredMap<String, String> map = clustering.getMap(MAP_ID);
    return map.get(key);
  }

  @PutMapping("/{key}/{value}")
  void get(@PathVariable("key") final String key, @PathVariable("value") final String value) {
    final ClusteredMap<String, String> map = clustering.getMap("map");
    map.put(key, value);
  }

  @DeleteMapping("/{key}")
  void delete(@PathVariable("key") final String key) {
    final ClusteredMap<String, String> map = clustering.getMap("map");
    map.remove(key);
  }

}
