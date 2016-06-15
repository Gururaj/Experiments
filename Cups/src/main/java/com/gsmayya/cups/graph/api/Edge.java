package com.gsmayya.cups.graph.api;

/**
 * Created by gseethar on 6/30/14.
 */
public interface Edge {
    Vertex getOpposite(Vertex v);

    Pair<Vertex, Vertex> getVertices();

    boolean contains(Vertex v);
}
