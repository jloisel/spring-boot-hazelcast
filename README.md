Spring Boot + Hazelcast Integration

## Introduction

Spring Boot Web application with configurable clustering:

- `cluster-api`: Interfaces hiding the clustering implementation used,
- `cluster-jvm`: no clustering backed by JVM data structures (like HashMap),
- `cluster-hazelcast`: clusterting backend by [Hazelcast](https://hazelcast.org).

This allows you to create a web application which supports single-jvm or clustered data structures depending on configuration in `application.yml`:

```yml
clustering:
  driver: hazelcast # Enable Hazelcast Clustering
```
## Pre-Requisites

This project uses [Lombok](https://projectlombok.org/) which requires **Annotations Processors** to be enabled in Eclipse / Intellij when importing from sources. Requires **Java 11** or later.

## Demo Application

Run with intellij:

- **Main class**: `com.octoperf.Application`
- **Use classpath of module**: `application`,
- **Working Directory**: `$MODULE_DIR$`,
- **VM Options**: `-Dspring.profiles.active=hazelcast` to run with hazelcast clustering. Nothing otherwise.

OR

Compile and build with shell:

- ./mvnw.sh clean package

Run with shell:

- java -Dspring.profiles.active=hazelcast -jar application/target/application-1.0-SNAPSHOT.jar

Tutorial: 

- https://octoperf.com/blog/2018/06/12/spring-boot-hazelcast-tutorial/