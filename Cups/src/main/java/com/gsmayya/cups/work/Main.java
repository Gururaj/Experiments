package com.gsmayya.cups.work;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.gsmayya.cups.sorting.InsertionSort;
import com.gsmayya.cups.sorting.MergeSort;
import com.gsmayya.cups.sorting.Sort;
import com.gsmayya.cups.Utils.Utils;
import com.gsmayya.cups.NullChecks.Computer;
import com.gsmayya.cups.NullChecks.SoundCard;
import com.gsmayya.cups.NullChecks.Usb;
import com.gsmayya.cups.guava.collections.WebSiteStats;

/**
 * Created by gseethar on 6/30/14.
 */
public class Main {

    public static void main(String[] args) {
	// Graph graph = new GraphImpl();
	// graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new
	// VertexImpl("v2")));
	// graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new
	// VertexImpl("v2")));
	// graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new
	// VertexImpl("v2")));
	// graph.addEdge(new EdgeImpl(new VertexImpl("v1"), new
	// VertexImpl("v2")));
	// System.out.println(graph);

	List<Sort> sorts = Lists.newArrayList();
	sorts.add(new InsertionSort());
	sorts.add(new MergeSort());
	Utils.runAll(sorts);
    }

    public static void mainCollections() {
	// testNullChecks();
	try {
	    testCollections();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private static void testCollections() throws IOException {
	WebSiteStats webSiteStats = new WebSiteStats("http://www.google.com");
	webSiteStats.process();
    }

    private static void testNullChecks() {
	for (int i = 0; i < 100; i++) {
	    Optional<Computer> computer = Optional.of(new Computer());
	    System.out.println(computer.flatMap(Computer::getSoundCard).flatMap(SoundCard::getUsb).map(Usb::getVersion)
		    .orElse("UNKNOWN"));
	}
    }
}
