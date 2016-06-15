package com.gsmayya.cups.graph;

import com.gsmayya.cups.graph.api.Edge;
import com.gsmayya.cups.graph.api.Pair;
import com.gsmayya.cups.graph.api.Vertex;

/**
 * Created by gseethar on 6/30/14.
 */
public class EdgeImpl implements Edge {

    private final Pair<Vertex, Vertex> _edge;

    public EdgeImpl(Vertex a, Vertex b) {
        _edge = new Pair<>(a, b);
    }

    @Override
    public Vertex getOpposite(Vertex v) {
        if (_edge.first().equals(v)) {
            return _edge.second();
        }
        return _edge.first();
    }

    @Override
    public Pair<Vertex, Vertex> getVertices() {
        return _edge;
    }

    @Override
    public boolean contains(Vertex v) {
        return (_edge.first().equals(v) || _edge.second().equals(v));
    }

    @Override
    public String toString() {
        return _edge.first() + " <---> " + _edge.second();
    }
}
