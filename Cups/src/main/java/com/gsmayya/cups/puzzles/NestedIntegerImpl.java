package com.gsmayya.cups.puzzles;

import java.util.List;


/**
 * Created by gseethar on 7/21/16.
 */
public class NestedIntegerImpl implements  NestedInteger {

  private List<NestedInteger> _ni = null;
  private Integer _in = null;

  public void addInteger(Integer in) {
    _in = in;
    // make sure that this contains only integer
    _ni = null;
  }

  public void addList(List<NestedInteger> ni) {
    _ni = ni;
    // make sure integer is null
    _in = null;
  }

  @Override
  public boolean isInteger() {
    return _in != null;
  }

  @Override
  public Integer getInteger() {
    return _in;
  }

  @Override
  public List<NestedInteger> getList() {
    return _ni;
  }
}
