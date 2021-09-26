package com.comp301.a02adventure;

import java.util.Objects;

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
    Object haha = name;

    return other != null && Objects.equals(haha.toString(), other.toString());
  }

  public String toString() {
    return this.name;
  }
}
