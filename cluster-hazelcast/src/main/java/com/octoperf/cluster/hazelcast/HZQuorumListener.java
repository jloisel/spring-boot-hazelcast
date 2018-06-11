package com.octoperf.cluster.hazelcast;

@FunctionalInterface
interface HZQuorumListener {

  boolean isQuorum();
}
