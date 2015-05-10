package com.gsmayya.java8.guava.collections;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by gseethar on 5/5/15.
 */
public class GoogleMapCollector<K, V> implements MapCollector<K, V> {

  private Multimap<K, V> _mmap = HashMultimap.create();

  public void collect(K token, V value) {
    _mmap.put(token, value);
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    _mmap.asMap().forEach(
        (k, v) -> {
          stringBuilder.append("Key = " + k);
          v.forEach(
              (value) -> stringBuilder.append(" Value = " + value + "\n"));
        }
    );

    return stringBuilder.toString();
  }
}
