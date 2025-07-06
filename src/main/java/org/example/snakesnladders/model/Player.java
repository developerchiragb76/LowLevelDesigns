package org.example.snakesnladders.model;

public class Player {
    private final String colour;
    private Box currentPosition;

    public Player(String colour, Box currentPosition) {
        this.colour = colour;
        this.currentPosition = currentPosition;
    }

    public String getColour() {
        return colour;
    }

    public Box getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Box currentPosition) {
        this.currentPosition = currentPosition;
    }
}
