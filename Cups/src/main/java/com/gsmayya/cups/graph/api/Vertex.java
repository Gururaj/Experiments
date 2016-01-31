package com.gsmayya.cups.graph.api;

import java.util.Set;

/**
 * Created by gseethar on 6/30/14.
 */
public interface Vertex {

    public String getName();

    public void add(Edge edge);

    public void remove(Edge edge);

    public Set<Edge> getEdges();

    public void clear();

    public boolean disconnected();

}
