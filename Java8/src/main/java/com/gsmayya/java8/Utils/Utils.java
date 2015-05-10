package com.gsmayya.java8.Utils;

import java.util.Optional;
import java.util.Random;

/**
 * Created by gseethar on 5/2/15.
 */
public class Utils {
  // TODO: Get bias

  public static <T> Optional<T> returnRandom(T in, int bias) {
    return (((new Random()).nextInt(bias) == 0)? Optional.empty():  Optional.of(in));
  }
}
