package com.gsmayya.cups.sorting;

import com.gsmayya.cups.Utils.Benchmark;

import java.util.List;

/**
 * Created by gseethar on 7/13/14.
 */
public class InsertionSort implements Sort {

    public InsertionSort() {

    }

    public static void main(String[] args) {
        System.out.println("Insertion Sort");
        Benchmark bm = new Benchmark();
        InsertionSort sort = new InsertionSort();
        bm.start(10, 10, sort, false, true);

    }

    private void shiftRight(int index, List<Integer> list) {
        list.set(index + 1, list.get(index));
    }

    // direction == true == ascending
    // direction == false = descending
    @Override
    public List<Integer> sort(List<Integer> list, boolean ascending) {
        for (int j = 1; j < list.size(); j++) {
            Integer key = list.get(j);
            int i = j - 1;
            // while (i >= 0 && list.get(i) > key) {
            // ( (! ascending && list.get(i) < key ) || (ascending &&
            // list.get(i) > key)) )
            while (i >= 0 && ((!ascending && list.get(i) < key) || (ascending && list.get(i) > key))) {
                // move to higher
                shiftRight(i, list);
                i--;
            }
            list.set(i + 1, key);
            // Utils.printList(_list);
        }
        return list;
    }

    @Override
    public String name() {
        return this.getClass().getName();
    }
}
