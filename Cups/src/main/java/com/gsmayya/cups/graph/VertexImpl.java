package com.gsmayya.cups.graph;

import com.gsmayya.cups.graph.api.Edge;
import com.gsmayya.cups.graph.api.Vertex;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by gseethar on 7/6/14.
 */
public class VertexImpl implements Vertex {

    private final Set<Edge> _edges;
    private final String _name;

    public VertexImpl(String name) {
        _edges = new HashSet<>();
        _name = name;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void add(Edge e) {
        _edges.add(e);
    }

    @Override
    public void remove(Edge e) {
        _edges.remove(e);
    }

    @Override
    public Set<Edge> getEdges() {
        return _edges;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vertex && (_name.equals(((Vertex) obj).getName()) || _edges.equals(((Vertex) obj).getEdges()));
    }

    @Override
    public void clear() {
        _edges.clear();
    }

    @Override
    public String toString() {
        return _name;
    }

    @Override
    public boolean disconnected() {
        return _edges.isEmpty();
    }
}
