package com.comp301.a02adventure;

public class PositionImpl implements Position {
  private final int x;
  private final int y;

  public PositionImpl(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public Position getNeighbor(Direction direction) {
    Position pos = new PositionImpl(x, y);
    if (direction == Direction.EAST) {
      pos = new PositionImpl(x + 1, y);
    }
    if (direction == Direction.NORTH) {
      pos = new PositionImpl(x, y - 1);
    }
    if (direction == Direction.SOUTH) {
      pos = new PositionImpl(x, y + 1);
    }
    if (direction == Direction.WEST) {
      pos = new PositionImpl(x - 1, y);
    }
    return pos;
  }
}
