package com.gsmayya.cups.graph;

import com.google.common.collect.Sets;
import com.gsm.graph.api.Edge;
import com.gsm.graph.api.Graph;
import com.gsm.graph.api.Pair;
import com.gsm.graph.api.Vertex;

import java.util.Set;

/**
 * Created by gseethar on 6/30/14.
 */
public class GraphImpl implements Graph {

    private final Set<Edge> _edges;
    private final Set<Vertex> _vertices;

    public GraphImpl() {
        _edges = Sets.newHashSet();
        _vertices = Sets.newHashSet();
    }


    @Override
    public boolean isDirected() {
        return false;
    }

    @Override
    public Vertex addVertex(Vertex v) {
        // remove any existing edges etc.
        v.clear();
        _vertices.add(v);
        return v;
    }

    @Override
    public Edge addEdge(Edge e) {
        _edges.add(e);
        Pair<Vertex, Vertex> pair = e.getVertices();
        // undirected, hence this edge belongs to both
        pair.first().add(e);
        pair.second().add(e);
        _vertices.add(pair.first());
        _vertices.add(pair.second());
        return e;
    }

    @Override
    public void removeVertex(Vertex v) {
        _vertices.remove(v);

        for( Edge edge : _edges) {
            if (edge.contains(v)) {
                _edges.remove(v);
                break;
            }
        }
    }

    @Override
    public void removeEdge(Edge e) {
        Pair<Vertex, Vertex> vertexPair = e.getVertices();
        vertexPair.first().remove(e);
        vertexPair.second().remove(e);
        _edges.remove(e);
    }

    @Override
    public Set getVertices() {
        return _vertices;
    }

    @Override
    public Set getEdges() {
        return _edges;
    }

    @Override
    public void removeVertices(Set vertices) {
        _vertices.clear();
    }

    @Override
    public void removeEdges(Set edges) {
        _edges.clear();
    }

    private String printEdges() {
        StringBuffer stringBuffer = new StringBuffer();
        for(Edge edge : _edges) {
            stringBuffer.append(edge);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

     private String printVertices() {
        StringBuffer stringBuffer = new StringBuffer();
        for(Vertex vertex : _vertices) {
            stringBuffer.append(vertex);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "GraphImpl{" +
                "_edges=" + printEdges() +
                ", _vertices=" + printVertices() +
                '}';
    }
}
