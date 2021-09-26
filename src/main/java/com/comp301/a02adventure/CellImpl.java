package com.comp301.a02adventure;

public class CellImpl implements Cell {
  private final Position position;
  private Inventory chest;
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
    if (name == null) {
      throw new IllegalArgumentException("name can not be null!");
    }
    this.name = name;
  }

  @Override
  public String getDescription() {

    return this.description;
  }

  @Override
  public void setDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException("description can not be null!");
    }
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
    if (chest == null) {
      throw new IllegalArgumentException("your input is null!");
    }
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
