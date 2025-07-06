package org.example.snakesnladders.model;

import org.example.snakesnladders.strategy.IGameEntity;

public class Box {
    private final int position;
    private IGameEntity entity;

    public Box(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public IGameEntity getEntity() {
        return entity;
    }

    public void setEntity(IGameEntity entity) {
        this.entity = entity;
    }
}
