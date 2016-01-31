package com.gsmayya.cups.NullChecks;

import java.util.Random;

/**
 * Created by gseethar on 5/2/15.
 */
public class Usb {
  private final String version;

  public Usb() {
    int v = (new Random()).nextInt(4);
    version = (v == 0)? null : String.valueOf(v + ".0");
  }

  public String getVersion() {
    return version;
  }
}
