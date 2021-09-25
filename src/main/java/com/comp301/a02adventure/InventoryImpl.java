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
    return list.size();
  }

  @Override
  public List<Item> getItems() {
    return list;
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
    List<Item> new_list = new ArrayList<>();
    list = new_list;
  }

  @Override
  public void transferFrom(Inventory other) {
    list = other.getItems();
    other.clear();
  }
}
