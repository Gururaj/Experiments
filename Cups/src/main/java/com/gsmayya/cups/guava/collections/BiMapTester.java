package com.gsmayya.cups.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * Created by gseethar on 5/5/15.
 */
public class BiMapTester<K, V> implements MapCollector<K, V> {

    BiMap<K, V> _pairs = HashBiMap.create();

    @Override
    public void collect(K token, V value) {
	_pairs.put(token, value);
    }

    @Override
    public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	_pairs.forEach((k, v) -> stringBuilder.append(k + " => " + v + "\n"));
	return stringBuilder.toString();
    }
}
