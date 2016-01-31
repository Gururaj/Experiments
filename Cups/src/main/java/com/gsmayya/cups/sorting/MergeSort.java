package com.gsmayya.cups.sorting;

import java.util.List;

import com.google.common.collect.Lists;
import com.gsm.utils.Benchmark;

/**
 * Created by gseethar on 7/13/14.
 */
public class MergeSort implements Sort {

  @Override
  public List<Integer> sort(List<Integer> list, boolean direction) {
    // for now ignore direction
    mergeSort(list, 0, list.size() - 1);
    return list;
  }

  private void mergeSort(List<Integer> list, int left, int right) {
    if (left < right) {
      int mid = (int) Math.floor((left + right) / 2);
      mergeSort(list, left, mid);
      mergeSort(list, mid + 1, right);
      merge(list, left, mid, right);
      //Utils.printList(list, true, false);
    }
  }

  private void merge(List<Integer> list, int left, int mid, int right) {

    List<Integer> leftArray = copy(list, left, mid);
    List<Integer> rightArray = copy(list, mid + 1, right);
    if (leftArray.size() == 0 || rightArray.size() == 0) {
      return;
    }
    //Utils.printList(leftArray, true, false);
    //Utils.printList(rightArray, true, false);
    //System.out.println(" " + left + " " + right);

    int i = 0;
    int j = 0;
    int lLen = leftArray.size();
    int rLen = rightArray.size();

    int index = left;
    assert lLen + rLen == right - left;

    // while there are elements in either of the array
    while (i < lLen && j < rLen) {
      if (leftArray.get(i) <= rightArray.get(j)) {
        list.set(index, leftArray.get(i));
        i++;
      } else {
        list.set(index, rightArray.get(j));
        j++;
      }
      index++;
    }
    // by now one of the list is ended.
    while (i < lLen) {
      list.set(index, leftArray.get(i));
      i++;
      index++;
    }
    while (j < rLen) {
      list.set(index, rightArray.get(j));
      j++;
      index++;
    }
  }

  private List<Integer> copy(List<Integer> list, int start, int end) {
    List<Integer> array = Lists.newArrayListWithCapacity(end - start);
    for (int i = start, j = 0; i <= end; i++, j++) {
      array.add(list.get(i));
    }
    return array;
  }

  public String name() {
    return this.getClass().getName();
  }

  public static void main(String[] args) {
    System.out.println("Merge Sort");
    Benchmark bm = new Benchmark();
    MergeSort sort = new MergeSort();
    bm.start(1, 10, sort, true, true);

  }
}
