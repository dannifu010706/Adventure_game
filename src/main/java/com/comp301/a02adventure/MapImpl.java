package com.comp301.a02adventure;

public class MapImpl implements Map {
  private final Cell[][] array;
  private final int numItems;

  public MapImpl(int width, int height, int numItems) {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("width or weight can not be 0 or less than 0");
    }

    Cell[][] grid = new Cell[width][height];
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
    if (x > array.length - 1 || y > array[0].length - 1) {

      throw new IndexOutOfBoundsException("You are out of dimension!");
    }
    return array[x][y];
  }

  @Override
  public Cell getCell(Position position) {
    if (position.getY() > array.length - 1 || position.getX() > array[0].length - 1) {
      throw new IndexOutOfBoundsException("You are out of dimension!");
    }
    return array[position.getX()][position.getY()];
  }

  @Override
  public void initCell(int x, int y) {
    Cell cell = new CellImpl(x, y);
    array[x][y] = cell;
  }

  @Override
  public int getNumItems() {
    return this.numItems;
  }
}
