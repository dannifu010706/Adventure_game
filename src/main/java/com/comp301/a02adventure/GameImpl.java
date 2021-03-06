package com.comp301.a02adventure;

import java.util.List;

import static com.comp301.a02adventure.Direction.EAST;

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
    return this.player.getInventory().getItems();
  }

  @Override
  public boolean getIsWinner() {
    return map.getNumItems() == player.getInventory().getNumItems();
  }

  @Override
  public void printCellInfo() {
    System.out.println("Location: " + map.getCell(player.getPosition()).getName());
    System.out.println(map.getCell(player.getPosition()).getDescription());
    if (map.getCell(player.getPosition()).getIsVisited() == true) {
      System.out.println("You have already visited this location.");
    }
    if (map.getCell(player.getPosition()).hasChest() == true) {
      System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
    }
    map.getCell(player.getPosition()).visit();
  }

  @Override
  public void openChest() {
    if (map.getCell(player.getPosition()).hasChest() == false) {
      System.out.println("No chest to open, sorry!");
    }
    if (map.getCell(player.getPosition()).hasChest() == true
        && map.getCell(player.getPosition()).getChest().getNumItems() == 0) {
      System.out.println("The chest is empty.");
    }
    if (map.getCell(player.getPosition()).hasChest() == true
        && map.getCell(player.getPosition()).getChest().getNumItems() != 0) {
      System.out.println(
          "You collected these items: " + map.getCell(player.getPosition()).getChest().getItems());
    }

    player.getInventory().transferFrom(map.getCell(player.getPosition()).getChest());
  }

  @Override
  public boolean canMove(Direction direction) {

    if (direction == EAST) {
      if (player.getPosition().getX() < map.getWidth() - 1) {
        if (map.getCell(player.getPosition().getX() + 1, player.getPosition().getY()) != null) {
          return true;
        }
      }
    }
    if (direction == Direction.NORTH) {
      if (player.getPosition().getY() < map.getHeight() - 1) {
        if (map.getCell(player.getPosition().getX(), player.getPosition().getY() + 1) != null) {
          return true;
        }
      }
    }
    if (direction == Direction.WEST) {
      if (player.getPosition().getX() - 1 >= 0) {
        if (map.getCell(player.getPosition().getX() - 1, player.getPosition().getY()) != null) {
          return true;
        }
      }
    }
    if (direction == Direction.SOUTH) {
      if (player.getPosition().getY() - 1 >= 0 == true) {
        return map.getCell(player.getPosition().getX(), player.getPosition().getY() - 1) != null;
      }
    }
    return false;
  }

  public void move(Direction direction) {
    Game game = new GameImpl(this.map, this.player);
    if (game.canMove(direction) == true) {
      player.move(direction);
      game.printCellInfo();

    } else {
      System.out.println("You can't go that way! Try another direction.");
    }
  }
}
