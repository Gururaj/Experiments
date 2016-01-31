package com.gsmayya.cups.graph.api;

/**
 * Created by gseethar on 6/30/14.
 */
public interface Edge {
    public Vertex getOpposite(Vertex v);

    public Pair<Vertex, Vertex> getVertices();

    public boolean contains(Vertex v);
}
