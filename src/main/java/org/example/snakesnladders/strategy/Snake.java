package org.example.snakesnladders.strategy;

import org.example.snakesnladders.model.Box;
import org.example.snakesnladders.model.Player;

public class Snake implements IGameEntity{
    private final Box snakeMouth;
    private final Box snakeTail;

    public Snake(Box snakeMouth, Box snakeTail) {
        this.snakeMouth = snakeMouth;
        this.snakeTail = snakeTail;
    }

    @Override
    public void apply(Player player) {
        if(player.getCurrentPosition().getPosition() == snakeMouth.getPosition()) {
            System.out.println("Snake Encountered");
            player.setCurrentPosition(snakeTail);
        }
    }
}
