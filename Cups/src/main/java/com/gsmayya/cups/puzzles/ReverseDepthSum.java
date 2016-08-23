package com.gsmayya.cups.puzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import static com.gsmayya.cups.puzzles.PuzzleUtils.populateNestedInteger;
import static com.gsmayya.cups.puzzles.PuzzleUtils.print;


/**
 * Created by gseethar on 7/21/16.
 */
public class ReverseDepthSum {

  //3x + 2y + z = 4(x + y + z) - (x + 2y + 3z)
  /**
   * Given a nested list of integers, returns the sum of all integers in the list weighted by their reversed depth.
   * For example, given the list {{1,1},2,{1,1}} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2)
   * Given the list {1,{4,{6}}} the function should return 17 (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)
   */
  static int reverseDepthSum1 (List<NestedInteger> input) {
    Map<Integer, Integer> levelSums = new HashMap<>();
    int maxDepth = reverseDepthSumHelper1(input, 1, levelSums);
    int totalSum = 0;
    for (int i = maxDepth; i > 0; i--) {
      totalSum += levelSums.get(i) * (maxDepth + 1 - i);
    }
    return totalSum;
  }

  // 1, 2, 3

  static int reverseDepthSumHelper1(List<NestedInteger> input, int depth,  Map<Integer, Integer> levelSums) {
    int sum = 0;
    int maxDepth = depth;
    if (input == null || input.isEmpty()) {
      return sum;
    }
    for (NestedInteger ni: input) {
      if (ni.isInteger()) {
        sum += ni.getInteger();
      } else {
        // another List so..
        maxDepth = reverseDepthSumHelper1(ni.getList(), depth + 1, levelSums);
      }
    }
    // add up to hashmap for sums
    if (levelSums.containsKey(depth)) {
      levelSums.put(depth, levelSums.get(depth) + sum);
    } else {
      levelSums.put(depth, sum);
    }
    // return the max of depths ever seen in this
    return Math.max(depth, maxDepth);
  }

  static int reverseDepthSum2(List<NestedInteger> input) {
    Triple<Integer, Integer, Integer> sums = reverseDepthSumHelper2(input, 1);
    return ( (sums.getRight() + 1) * sums.getMiddle()) - sums.getLeft();
  }


  static Triple<Integer, Integer, Integer> reverseDepthSumHelper2(List<NestedInteger> input, int depth) {

    int depthSum = 0;
    int levelSum = 0;
    int maxDepth = depth;

    if (input == null || input.isEmpty()) {
      return new ImmutableTriple<>(0, 0, 0);
    }
    for (NestedInteger ni: input) {
      if (ni.isInteger()) {
        depthSum += ni.getInteger() * depth;
        levelSum += ni.getInteger();
      } else {
        // another List so..
        Triple<Integer, Integer, Integer> recRes = reverseDepthSumHelper2(ni.getList(), depth + 1);
        depthSum += recRes.getLeft();
        levelSum += recRes.getMiddle();
        maxDepth = recRes.getRight();
      }
    }
    return new ImmutableTriple<>(depthSum, levelSum, Math.max(depth, maxDepth));
  }


  // using math equation. We still need level sums


  public static void main(String[] args) {
    List<NestedInteger> ni = new ArrayList<>();
    populateNestedInteger(ni);
    System.out.print(print(ni) + "\n");
    System.out.println(PuzzleUtils.callWithTimer(() -> reverseDepthSum1(ni), 100000));
    System.out.println(PuzzleUtils.callWithTimer(() -> reverseDepthSum2(ni), 100000));
    System.out.println(reverseDepthSum1(ni));
    System.out.println(reverseDepthSum2(ni));
  }

}
