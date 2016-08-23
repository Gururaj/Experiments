package com.gsmayya.learn.java.dp;

import java.util.ArrayList;

/**
 * Created by gsmay on 14-08-2016.
 */
public class Int3Function {



    public int getMinSteps(int n) {
        ArrayList<Integer> memo = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            memo.add(i, -1);
        }
        return getMinStepsHelper(n, memo);
    }

    public int getMinStepsBottomUp(int n) {
        ArrayList<Integer> memo = new ArrayList<>(n+1);
        memo.add(0, 0);
        memo.add(1, 0);
        for (int i = 2; i <= n; i++) {
            memo.add(i, memo.get(i-1) + 1);
            if (i % 2 == 0) {
                memo.add(i, Math.min(memo.get(i), 1 + memo.get(i / 2)));
            }
            if (i % 3 == 0) {
                memo.add(i, Math.min(memo.get(i), 1 + memo.get(i/3)));
            }
        }
        return memo.get(n+1);
    }

    private int getMinStepsHelper(int n, ArrayList<Integer> memo) {
        if (n == 1) {
            return 0;
        }

        if (memo.get(n) != -1) {
            return memo.get(n);
        }

        int r = 1 + getMinStepsHelper(n-1, memo);
        if (n % 2 == 0) {
            r = Math.min(r, 1 + getMinStepsHelper(n/2, memo));
        }
        if (n % 3 == 0) {
            r = Math.min(r, 1 + getMinStepsHelper(n/3, memo));
        }
        memo.add(n, r);
        return r;
    }
}
