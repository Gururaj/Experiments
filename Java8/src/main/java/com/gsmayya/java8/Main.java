package com.gsmayya.java8;


import com.gsmayya.java8.NullChecks.Computer;
import com.gsmayya.java8.NullChecks.SoundCard;
import com.gsmayya.java8.NullChecks.Usb;
import com.gsmayya.java8.guava.collections.WebSiteStats;

import java.io.IOException;
import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    //testNullChecks();
    try {
      testCollections();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void testCollections() throws IOException {
    WebSiteStats webSiteStats = new WebSiteStats("http://www.google.com");
    webSiteStats.process();
  }


  private static void testNullChecks() {
    for (int i =0 ;i < 100; i++) {
      Optional<Computer> computer = Optional.of(new Computer());
      System.out.println(computer.flatMap(Computer::getSoundCard)
                             .flatMap(SoundCard::getUsb)
                             .map(Usb::getVersion)
                             .orElse("UNKNOWN"));
    }
  }
}