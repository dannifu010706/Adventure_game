package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

  private ArrayList<Item> list;

  public InventoryImpl() {

    this.list = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  @Override
  public int getNumItems() {
    return this.list.size();
  }

  @Override
  public List<Item> getItems() {
    ArrayList<Item> list_copy = new ArrayList<Item>();
    for (int i = 0; i < this.list.size(); i++) {
      list_copy.add(list.get(i));
    }
    return list_copy;
  }

  @Override
  public void addItem(Item item) {
    this.list.add(item);
  }

  @Override
  public void removeItem(Item item) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getName() == item.getName()) {
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
    if (other.isEmpty()) {
      throw new IllegalArgumentException("The Object is empty!");
    }
    ArrayList<Item> list2 = new ArrayList<Item>();
    for (int i = 0; i < other.getItems().size(); i++) {
      if (other.getItems() != null) {
        list2.add(other.getItems().get(i));
      }
    }
    this.list = list2;
    other.getItems().clear();
  }
}
