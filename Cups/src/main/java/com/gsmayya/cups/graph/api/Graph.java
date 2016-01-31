package com.gsmayya.cups.graph.api;

import java.util.Set;

/**
 * Created by gseethar on 6/30/14.
 */
public interface Graph {

    default public boolean isDirected() {
        return false;
    }

    public Vertex addVertex(Vertex v);

    public Edge addEdge(Edge e);

    public void removeVertex(Vertex v);

    public void removeEdge(Edge e);

    public Set<Vertex> getVertices();

    public Set<Vertex> getEdges();

    public void removeVertices(Set<Vertex> vertices);

    public void removeEdges(Set<Vertex> edges);
}
