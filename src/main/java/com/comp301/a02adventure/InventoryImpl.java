package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {

    private List<Item> list;

    public InventoryImpl() {
        List<Item> alist = new ArrayList<>();
        this.list = alist;
    }

    @Override
    public boolean isEmpty() {
        return list == null;
    }

    @Override
    public int getNumItems() {
        return this.list.size();


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
        this.list.remove(item);

    }

    @Override
    public void clear() {
        List<Item> new_list = new ArrayList<>();
        this.list = new_list;

    }

    @Override
    public void transferFrom(Inventory other) {
        this.list = other.getItems();
        other.clear();

    }
}