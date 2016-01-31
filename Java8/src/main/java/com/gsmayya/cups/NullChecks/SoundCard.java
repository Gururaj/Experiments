package com.gsmayya.java8.NullChecks;

import com.gsmayya.java8.Utils.Utils;

import java.util.Optional;

/**
 * Created by gseethar on 5/2/15.
 */
public class SoundCard {

  private Optional<Usb> usb;

  public SoundCard() {
    int myBias = 10;
    usb = Utils.returnRandom(new Usb(), myBias);
  }

  public Optional<Usb> getUsb() {
    return usb;
  }

}
