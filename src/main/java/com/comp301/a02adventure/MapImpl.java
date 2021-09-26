package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final int[][] array;
  private final int numItems;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("width or weight can not be null");
    }

    int[][] grid = new int[width][height];
    this.array = grid;

    this.numItems = numItems;
  }

  @Override
  public int getWidth() {
    return this.array.length;
  }

  @Override
  public int getHeight() {
    return this.array[0].length;
  }

  @Override
  public Cell getCell(int x, int y) {
    if (x > array.length || y > array[0].length) {

      throw new IllegalArgumentException("You are out of dimension!");
    }
    Cell cell1 = new CellImpl(x, y);
    return cell1;
  }

  @Override
  public Cell getCell(Position position) {
    if (position.getY() > array.length || position.getX() > array[0].length) {
      throw new IllegalArgumentException("You are out of dimension!");
    }
    Cell cell2 = new CellImpl(position.getX(), position.getY());
    return cell2;
  }

  @Override
  public void initCell(int x, int y) {
    Cell cell3 = new CellImpl(x, y);
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
