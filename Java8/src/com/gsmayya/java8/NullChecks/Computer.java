package com.gsmayya.java8.NullChecks;

import com.gsmayya.java8.Utils.Utils;

import java.util.Optional;


public class Computer {
  Optional<SoundCard> soundCard;

  public Computer() {
    // a random setting
    soundCard = Utils.returnRandom(new SoundCard(), 2);
  }

  public Optional<SoundCard> getSoundCard() {
    return soundCard;
  }
}
