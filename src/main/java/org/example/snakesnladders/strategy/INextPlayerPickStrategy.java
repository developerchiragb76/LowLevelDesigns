package org.example.snakesnladders.strategy;

import org.example.snakesnladders.model.Player;

import java.util.List;

public interface INextPlayerPickStrategy {
    Player pickNextPlayer(List<Player> playerList);
}
