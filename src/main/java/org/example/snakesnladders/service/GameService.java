package org.example.snakesnladders.service;

import org.example.snakesnladders.model.Board;
import org.example.snakesnladders.model.Box;
import org.example.snakesnladders.model.Dice;
import org.example.snakesnladders.model.Player;
import org.example.snakesnladders.strategy.IGameEntity;
import org.example.snakesnladders.strategy.INextPlayerPickStrategy;
import org.example.snakesnladders.strategy.IPlayerWinningStrategy;

import java.util.List;

public class GameService {
    private final Board board;
    private final Dice dice;
    private final List<Player> playerList;
    private final INextPlayerPickStrategy nextPlayerPickStrategy;
    private final IPlayerWinningStrategy playerWinningStrategy;

    public GameService(Board board, Dice dice, List<Player> playerList, INextPlayerPickStrategy nextPlayerPickStrategy, IPlayerWinningStrategy playerWinningStrategy) {
        this.board = board;
        this.dice = dice;
        this.playerList = playerList;
        this.nextPlayerPickStrategy = nextPlayerPickStrategy;
        this.playerWinningStrategy = playerWinningStrategy;
    }

    public void startGame() {
        while(true) {
            Player player = nextPlayerPickStrategy.pickNextPlayer(playerList);
            int position = dice.roll();
            position+=player.getCurrentPosition().getPosition();
            Box currentBox = board.getBoxPosition(position);
            player.setCurrentPosition(currentBox);
            if(playerWinningStrategy.isPlayerWon(player)) {
                System.out.println("Player With " + player.getColour() + " Won");
                return;
            }
            if(currentBox.getEntity() != null) {
                currentBox.getEntity().apply(player);
            }
        }
    }
}
