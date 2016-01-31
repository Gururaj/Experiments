package com.gsmayya.cups.guava.collections;

/**
 * Created by gseethar on 5/5/15.
 */
public interface MapCollector<K, V> {
    public void collect(K token, V value);
}
