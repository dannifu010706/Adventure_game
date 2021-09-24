package com.comp301.a02adventure;

public class CellImpl implements Cell {
    Position position = new PositionImpl(0, 0);
    Inventory chest = new InventoryImpl();
    private String name;
    private String description;
    private boolean track = false;
    private boolean chest_track = false;

    public CellImpl(int x, int y, String name, String description) {
        if (name == null || description == null) {
            throw new IllegalArgumentException("name or description cannot be null");
        }
        Position new_position = new PositionImpl(x, y);
        this.position = new_position;
        this.name = name;
        this.description = description;

    }

    public CellImpl(int x, int y) {
        this(x, y, "", "");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;

    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Inventory getChest() {
        return this.chest;
    }

    @Override
    public void setChest(Inventory chest) {
        this.chest = chest;
        this.chest_track = true;

    }

    @Override
    public boolean getIsVisited() {
        return track;
    }

    @Override
    public boolean hasChest() {
        return chest_track;
    }

    @Override
    public void visit() {
        this.track = true;

    }
}