package org.example.snakesnladders.strategy;

import org.example.snakesnladders.model.Player;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPlayerPickStrategy implements INextPlayerPickStrategy{
    @Override
    public Player pickNextPlayer(List<Player> playerList) {
        int playerIndex = ThreadLocalRandom.current().nextInt(0, playerList.size());
        return playerList.get(playerIndex);
    }
}
