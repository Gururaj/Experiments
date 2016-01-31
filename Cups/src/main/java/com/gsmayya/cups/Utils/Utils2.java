package com.gsmayya.cups.Utils;

import java.util.List;
import java.util.Random;

import com.google.common.collect.Lists;
import com.gsmayya.cups.sorting.Sort;

/**
 * Created by gseethar on 7/13/14.
 */
public class Utils2 {

    public static List<Integer> generate(int min, int max, int count) {
	Random random = new Random();
	List<Integer> retSet = Lists.newArrayList();
	for (int i = 0; i < count;) {
	    int randomNum = random.nextInt((max - min) + 1) + min;
	    if (retSet.contains(randomNum)) {
		continue;
	    } else {
		retSet.add(randomNum);
		i++;
	    }
	}
	return retSet;
    }

    public static void printList(List<Integer> list, boolean ascending, boolean check, boolean print) {
	if (!validate(list, ascending) && check) {
	    System.out.println("Not in sort order");
	}
	if (print) {
	    for (Integer integer : list) {
		System.out.print(integer + " ");
	    }
	    System.out.println();
	}
    }

    public static boolean validate(List<Integer> list, boolean ascending) {
	for (int i = 0; i < list.size() - 1; i++) {
	    if ((ascending && list.get(i) > list.get(i + 1)) || (!ascending && list.get(i) < list.get(i + 1))) {
		return false;
	    }
	}
	return true;
    }

    public static void runAll(final List<Sort> sorts) {
	Benchmark benchmark = new Benchmark();
	for (Sort sort : sorts) {
	    benchmark.start(100000, 1000, sort, true, false);
	}
    }
}
