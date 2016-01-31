package com.gsmayya.cups.NullChecks;

import java.util.Optional;

import com.gsmayya.cups.Utils.Utils;


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
