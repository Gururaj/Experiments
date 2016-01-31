package com.gsmayya.cups.graph.api;

/**
 * Created by gseethar on 6/30/14.
 */
public class Pair<F, S> {
    F _first;
    S _second;

    public Pair(F first, S second) {
        _first = first;
        _second = second;
    }

    public F first() {
        return _first;
    }

    public S second() {
        return _second;
    }

}
