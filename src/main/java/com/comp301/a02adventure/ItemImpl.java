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
        return this.name;
    }

    public boolean equals(Object other) {

        if (this.name == other.getClass().getName()) {
            return true;
        }
        ;
        return false;
    }

    public String toString() {
        return this.name;
    }
}