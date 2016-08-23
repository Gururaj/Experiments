package com.gsmayya.cups.puzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


/**
 * Created by gseethar on 7/21/16.
 */
public class PuzzleUtils {

  public static<F> Double callWithTimer(Callable<F> callable, int reps) {
    long start = System.currentTimeMillis();
    for (int i = 0; i< reps; i++) {
      try {
        callable.call();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    long elapsed = System.currentTimeMillis() - start;
    return (elapsed * 1000.0)/reps;
  }

  public static String print(List<NestedInteger> ni) {
    StringBuilder sb = new StringBuilder("{");
    for (NestedInteger n : ni) {
      if (n.isInteger()) {
        sb.append(n.getInteger());
        sb.append(",");
      } else {
        sb.append(print(n.getList()));
        sb.append(",");
      }
    }
    sb.append("}");
    return sb.toString();
  }

  public static void populateNestedInteger(List<NestedInteger> ni) {

    /* {1, {4, {6}}}
    ni.add(createInt(1));
    ni.add(createList(
        createInt(4),
        createList(createInt(6))));
        */
    // {{1,1},2,{1,1}}
    ni.add(createList(createInt(1), createInt(1)));
    ni.add(createInt(2));
    ni.add(createList(createInt(1), createInt(1)));
  }

  private static NestedInteger createInt(Integer in) {
    NestedIntegerImpl niInt = new NestedIntegerImpl();
    niInt.addInteger(in);
    return niInt;
  }

  private static NestedInteger createList(NestedInteger ... list) {
    NestedIntegerImpl ni = new NestedIntegerImpl();
    List<NestedInteger> niList = new ArrayList<>();

    for (NestedInteger in: list) {
      niList.add(in);
    }
    ni.addList(niList);
    return ni;
  }

}
