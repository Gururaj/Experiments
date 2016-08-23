package com.gsmayya.learn.java.dp;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;


/**
 * Created by gsmay on 14-08-2016.
 */
public class LCS {
    //given two strings x and y, find the longest common subsequence (LCS) and print its length
    private Table<Integer, Integer, Integer> d = HashBasedTable.create();

    public Integer maxLCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i <= n; i++) {
            d.put(i, 0, 0);
        }
        for (int j = 0; j <= m; j++) {
            d.put(0, j, 0);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    d.put(i, j, d.get(i - 1, j - 1) + 1);
                } else {
                    d.put(i, j, Math.max(d.get(i - 1, j), d.get(i, j - 1)));
                }
            }
        }

        return d.get(str1.length(), str2.length());
    }
}
