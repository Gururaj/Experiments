package com.gsmayya.cups.graph.api;

import java.util.Set;

/**
 * Created by gseethar on 6/30/14.
 */
public interface Graph {

    default boolean isDirected() {
        return false;
    }

    Vertex addVertex(Vertex v);

    Edge addEdge(Edge e);

    void removeVertex(Vertex v);

    void removeEdge(Edge e);

    Set<Vertex> getVertices();

    Set<Vertex> getEdges();

    void removeVertices(Set<Vertex> vertices);

    void removeEdges(Set<Vertex> edges);
}
