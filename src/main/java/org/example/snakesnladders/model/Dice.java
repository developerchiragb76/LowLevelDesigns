package org.example.snakesnladders.model;

import java.util.concurrent.ThreadLocalRandom;


public class Dice {
    private final int numFaces;

    public Dice(int numFaces) {
        this.numFaces = numFaces;
    }

    public int getNumFaces() {
        return numFaces;
    }

    public int roll() {
        return ThreadLocalRandom.current().nextInt(1, 6 * numFaces + 1);
    }
}
