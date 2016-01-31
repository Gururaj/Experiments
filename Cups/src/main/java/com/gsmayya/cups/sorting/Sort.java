package com.gsmayya.cups.sorting;

import java.util.List;

/**
 * Created by gseethar on 7/13/14.
 */
public interface Sort {
  public List<Integer> sort(List<Integer> list, boolean direction);

  public String name();

}
