package com.comp301.a02adventure;

public final class ItemImpl implements Item {
    private final String name;


    public ItemImpl(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null!");
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    public boolean equals(Object other) {

        return this.name == other.getClass().getName();
    }

    public String toString() {
        return this.name;
    }
}