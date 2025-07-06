package org.example.snakesnladders;

import org.example.snakesnladders.model.Board;
import org.example.snakesnladders.model.Box;
import org.example.snakesnladders.model.Dice;
import org.example.snakesnladders.model.Player;
import org.example.snakesnladders.service.GameService;
import org.example.snakesnladders.strategy.*;

import java.util.List;

public class GameDriver {
    public static void main(String[] args) {
        Board board = new Board();
        Dice dice = new Dice(1);
        Player player1 = new Player("Red", new Box(0));
        Player player2 = new Player("Blue", new Box(0));
        IGameEntity snake1 = new Snake(new Box(50), new Box(20));
        IGameEntity snake2 = new Snake(new Box(75), new Box(35));

        IGameEntity ladder1 = new Ladder(new Box(25), new Box(52));
        IGameEntity ladder2 = new Ladder(new Box(60), new Box(90));

        INextPlayerPickStrategy nextPlayerPickStrategy = new RoundRobinPlayerPickingStrategy();
        IPlayerWinningStrategy playerWinningStrategy = new DefaultWinningStrategy();

        board.addEntity(50, snake1);
        board.addEntity(75, snake2);
        board.addEntity(25, ladder1);
        board.addEntity(60, ladder2);

        GameService gameService = new GameService(board, dice, List.of(player1, player2), nextPlayerPickStrategy, playerWinningStrategy);

        gameService.startGame();

        /*
            with factory pattern
        */

        GameService standardGameService = new GameFactory().getStandardSnakesAndLadderGameConfig(player1, player2);
        standardGameService.startGame();
    }
}
