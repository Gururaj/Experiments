package com.gsmayya.learn.java.dp;

import java.util.ArrayList;

/**

 Number of sums from 1, 3 and 4
 Recurrence is then
 Dn = Dn−1 + Dn−3 + Dn−4
 ◮ Solve the base cases
 – D0 = 1
 – Dn = 0 for all negative n
 – Alternatively, can set: D0 = D1 = D2 = 1, and D3 = 2
 We’re basically done!

 */
public class DPJavaPrg {
    private ArrayList<Integer> dp = new ArrayList<>();

    public DPJavaPrg() {
        dp.add(0, 1);
        dp.add(1, 1);
        dp.add(2, 1);
        dp.add(3, 2);
    }

    public Integer getCount(int n) {
        for (int i = 4; i <= n; i++) {
            dp.add(i, dp.get(i-1) + dp.get(i-3) + dp.get(i-4));
        }
        return dp.get(n);
    }
}
