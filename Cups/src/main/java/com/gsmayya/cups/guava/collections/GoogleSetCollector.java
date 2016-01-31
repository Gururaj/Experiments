package com.gsmayya.cups.guava.collections;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * Created by gseethar on 5/5/15.
 */
public class GoogleSetCollector implements SetCollector {

    private final Multiset<String> _map = HashMultiset.create();

    @Override
    public void collect(String token) {
	_map.add(token);
    }

    @Override
    public String toString() {
	StringBuilder stringBuilder = new StringBuilder();
	_map.elementSet().forEach((t) -> {
	    stringBuilder.append(t + " " + _map.count(t) + "\n");
	});
	return stringBuilder.toString();
    }
}
