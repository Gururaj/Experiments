package com.gsmayya.cups.puzzles;

import java.util.ArrayList;
import java.util.List;

import static com.gsmayya.cups.puzzles.PuzzleUtils.populateNestedInteger;
import static com.gsmayya.cups.puzzles.PuzzleUtils.print;


/**
 * Created by gseethar on 7/21/16.
 */
public class DepthSum {

  /**
   * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
   * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1)
   * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
   */
  static int depthSum (List<NestedInteger> input) {
    return depthSumHelper(input, 1);
  }

  static int depthSumHelper(List<NestedInteger> input, int depth) {
    int sum = 0;
    if (input == null || input.isEmpty()) {
      return sum;
    }
    for (NestedInteger ni: input) {
      if (ni.isInteger()) {
        sum += ni.getInteger() * depth;
      } else {
        // another List so..
        sum += depthSumHelper(ni.getList(), depth + 1);
      }
    }
    return sum;
  }


  public static void main(String[] args) {
    List<NestedInteger> ni = new ArrayList<>();
    populateNestedInteger(ni);
    System.out.print(print(ni) + "\n");
    System.out.println(PuzzleUtils.callWithTimer(() -> depthSum(ni), 100000));
    System.out.println(depthSum(ni));
  }


}
