package org.example.snakesnladders;

import org.example.snakesnladders.model.Board;
import org.example.snakesnladders.model.Dice;
import org.example.snakesnladders.model.Player;
import org.example.snakesnladders.service.GameService;
import org.example.snakesnladders.strategy.DefaultWinningStrategy;
import org.example.snakesnladders.strategy.RoundRobinPlayerPickingStrategy;

import java.util.List;

public class GameFactory {
    public GameService getStandardSnakesAndLadderGameConfig(Player p1, Player p2) {
        return new GameService(new Board(), new Dice(1), List.of(p1, p2), new RoundRobinPlayerPickingStrategy(), new DefaultWinningStrategy());
    }
}
