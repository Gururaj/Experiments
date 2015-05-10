package com.gsmayya.java8.guava.collections;

import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.map.MultiValueMap;

import java.util.Collection;

/**
 * Created by gseethar on 5/5/15.
 */
public class ApacheMapCollector<K, V> implements MapCollector<K, V> {

  private final MultiMap<K, V> _map = new MultiValueMap<>();

  @Override
  public void collect(K token, V value) {
    _map.put(token, value);
  }

   @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();


    _map.forEach(
        (k, v) -> {
          stringBuilder.append("Key = " + k);
          ((Collection) v).forEach(
              (value) -> stringBuilder.append(" Value = " + value + "\n"));
        }
    );

    return stringBuilder.toString();
  }
}
