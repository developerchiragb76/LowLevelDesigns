package org.example.snakesnladders.strategy;

import org.example.snakesnladders.model.Box;
import org.example.snakesnladders.model.Player;

public class Ladder implements IGameEntity{
    private final Box ladderStart;
    private final Box ladderEnd;

    public Ladder(Box ladderStart, Box ladderEnd) {
        this.ladderStart = ladderStart;
        this.ladderEnd = ladderEnd;
    }

    @Override
    public void apply(Player player) {
        if(player.getCurrentPosition().getPosition() == ladderStart.getPosition()) {
            System.out.println("Ladder Encoutered");
            player.setCurrentPosition(ladderEnd);
        }
    }
}
