package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

  private List<Item> list;

  public InventoryImpl() {

    List<Item> alist = new ArrayList<>();
    list = alist;
  }

  @Override
  public boolean isEmpty() {
    return list == null;
  }

  @Override
  public int getNumItems() {
    int count = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null) {
        count++;
      }
    }
    return count;
  }

  @Override
  public List<Item> getItems() {
    ArrayList<Item> item = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null) {

        item.add(list.get(i));
      }
    }
    return item;
  }

  @Override
  public void addItem(Item item) {
    list.add(item);
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

    list.clear();
  }

  @Override
  public void transferFrom(Inventory other) {
    this.list = other.getItems();
    other.clear();
  }
}
