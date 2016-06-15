package com.gsmayya.cups.graph.api;

import java.util.Set;

/**
 * Created by gseethar on 6/30/14.
 */
public interface Vertex {

    String getName();

    void add(Edge edge);

    void remove(Edge edge);

    Set<Edge> getEdges();

    void clear();

    boolean disconnected();

}
