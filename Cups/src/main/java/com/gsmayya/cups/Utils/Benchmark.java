package com.gsmayya.cups.Utils;

import java.util.List;

import com.google.common.collect.Lists;
import com.gsmayya.cups.sorting.Sort;

/**
 * Created by gseethar on 7/13/14.
 */
public class Benchmark {

    public Benchmark() {

    }

    public void start(int reps, int count, Sort sort, boolean ascending, boolean print) {

	List<List<Integer>> data = Lists.newArrayList();

	for (int i = 0; i < reps; i++) {
	    data.add(Utils.generate(0, 1000, count));
	}

	long start = System.currentTimeMillis();
	for (List<Integer> list : data) {
	    sort.sort(list, ascending);
	}
	long elapsed = System.currentTimeMillis() - start;

	if (print) {
	    for (List<Integer> list : data) {
		// ignore reps for now
		Utils.printList(list, ascending, true, print);
	    }
	}
	System.out.println(sort.name() + " elapsed time = " + elapsed + "ms");
	System.out.println((elapsed * 1000.0) / reps + " microseconds per execution");
    }

}
