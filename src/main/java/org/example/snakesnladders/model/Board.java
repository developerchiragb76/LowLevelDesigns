package org.example.snakesnladders.model;

import org.example.snakesnladders.strategy.IGameEntity;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Box> cells;

    public Board() {
        this.cells = new ArrayList<>();
        for(int i=1; i<=100; i++) {
            Box box = new Box(i);
            cells.add(box);
        }
    }

    public void addEntity(int startPosition, IGameEntity entity) {
        getBox(startPosition).setEntity(entity);
    }

    public Box getBox(int position) {
        return cells.get(position - 1);
    }

    public Box getBoxPosition(int position) {
        return getBox((position-1) % cells.size()+1);
    }
}
