package org.example.snakesnladders.strategy;

import org.example.snakesnladders.model.Player;

public class DefaultWinningStrategy implements IPlayerWinningStrategy{
    @Override
    public boolean isPlayerWon(Player player) {
        return player.getCurrentPosition().getPosition() >= 100;
    }
}
