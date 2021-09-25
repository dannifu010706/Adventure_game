package com.comp301.a02adventure;

import java.util.List;

public class GameImpl implements Game {
  private final Map map;
  private final Player player;

  public GameImpl(Map map, Player player) {
    if (map == null || player == null) {
      throw new IllegalArgumentException("Map or Player can not be null!");
    }
    this.map = map;
    this.player = player;
  }

  @Override
  public Position getPlayerPosition() {
    return this.player.getPosition();
  }

  @Override
  public String getPlayerName() {
    return this.player.getName();
  }

  @Override
  public List<Item> getPlayerItems() {
    return this.getPlayerItems();
  }

  @Override
  public boolean getIsWinner() {
    return map.getNumItems() == getPlayerItems().size();
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(player.getPosition()).getName());
  }

  @Override
  public void openChest() {
    if (map.getCell(player.getPosition()).hasChest() == false) {
      System.out.println("No chest to open, sorry!");
      if (map.getCell(player.getPosition()).hasChest() == true
          && map.getCell(player.getPosition()).getChest().getNumItems() == 0) {
        System.out.println("The chest is empty.");
      } else {
        System.out.println(
            "You collected these items: "
                + map.getCell(player.getPosition()).getChest().getItems().toString());
        player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
      }
    }
  }

  @Override
  public boolean canMove(Direction direction) {
    if (direction == Direction.EAST) {
      if (player.getPosition().getX() + 1 < map.getWidth()) {
        return true;
      }
    }
    if (direction == Direction.NORTH) {
      if (player.getPosition().getY() - 1 >= 0) {
        return true;
      }
    }
    if (direction == Direction.WEST) {
      if (player.getPosition().getX() - 1 >= 0) {
        return true;
      }
    }
    if (direction == Direction.SOUTH) {
      return player.getPosition().getY() + 1 <= map.getHeight();
    }
    return false;
  }

  @Override
  public void move(Direction direction) {
    Game game = new GameImpl(this.map, this.player);
    if (game.canMove(direction) == true) {
      game.printCellInfo();
      player.move(direction);
    } else {
      System.out.println("You can't go that way! Try another direction");
    }
  }
}
