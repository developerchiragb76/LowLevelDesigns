package org.example.snakesnladders.strategy;

import org.example.snakesnladders.model.Player;

import java.util.List;

public class RoundRobinPlayerPickingStrategy implements INextPlayerPickStrategy{
    private int playerIndex = 0;
    @Override
    public Player pickNextPlayer(List<Player> playerList) {
        Player player = playerList.get(playerIndex%playerList.size());
        playerIndex++;
        return player;
    }
}
