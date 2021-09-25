package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

  private ArrayList<Item> list;

  public InventoryImpl() {

    this.list = new ArrayList<Item>();
  }

  @Override
  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  @Override
  public int getNumItems() {
    int count = 0;
    for (int i = 0; i < list.size(); i++) {
      if (this.list.get(i) != null) {
        count++;
      }
    }
    return count;
  }

  @Override
  public List<Item> getItems() {
    return this.list;
  }

  @Override
  public void addItem(Item item) {
    this.list.add(item);
  }

  @Override
  public void removeItem(Item item) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == item) {
        list.remove(i);
      }
    }
  }

  @Override
  public void clear() {

    this.list.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    ArrayList<Item> newlist = new ArrayList<Item>();
    for (int i = 0; i < other.getItems().size(); i++) {
      if (other.getItems().get(i) != null) {
        newlist.add(other.getItems().get(i));
      }
    }
    this.list = newlist;
    other.clear();
  }
}
