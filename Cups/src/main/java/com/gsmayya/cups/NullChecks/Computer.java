package com.gsmayya.cups.NullChecks;

import com.gsmayya.cups.Utils.Utils;

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
