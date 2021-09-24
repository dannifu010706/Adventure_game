package com.comp301.a02adventure;

public class PlayerImpl implements Player {
    private final String name;
    private Position player_position;
    private Inventory inventory;


    public PlayerImpl(String name, int startX, int startY) {
        if (name == null) {
            throw new IllegalArgumentException("name can't be null!");
        }
        Position new_positon = new PositionImpl(startX, startY);
        this.player_position = new_positon;
        this.name = name;
    }

    @Override
    public Position getPosition() {
        return player_position;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void move(Direction direction) {
        if (direction == Direction.EAST) {
            this.player_position = this.player_position.getNeighbor(Direction.EAST);
        }
        if (direction == Direction.NORTH) {
            this.player_position = this.player_position.getNeighbor(Direction.NORTH);
        }
        if (direction == Direction.WEST) {
            this.player_position = this.player_position.getNeighbor(Direction.SOUTH);
        }
        if (direction == Direction.WEST) {
            this.player_position = this.player_position.getNeighbor(Direction.WEST);
        }
    }
}