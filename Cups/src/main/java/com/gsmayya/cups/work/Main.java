package com.gsmayya.cups.work;

import java.util.List;

import com.google.common.collect.Lists;
import com.gsm.sorting.InsertionSort;
import com.gsm.sorting.MergeSort;
import com.gsm.sorting.Sort;
import com.gsm.utils.Utils;

/**
 * Created by gseethar on 6/30/14.
 */
public class Main {

  public static void main(String[] args) {
//    Graph graph = new GraphImpl();
//    graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new VertexImpl("v2")));
//    graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new VertexImpl("v2")));
//    graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new VertexImpl("v2")));
//    graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new VertexImpl("v2")));
//    System.out.println(graph);

      List<Sort> sorts = Lists.newArrayList();
      sorts.add(new InsertionSort());
      sorts.add(new MergeSort());
      Utils.runAll(sorts);
  }
}
