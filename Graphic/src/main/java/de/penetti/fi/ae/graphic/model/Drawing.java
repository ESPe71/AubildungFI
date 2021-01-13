package de.penetti.fi.ae.graphic.model;

import de.penetti.fi.ae.graphic.model.primitive.Primitive;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
  private List<Primitive> primitives = new ArrayList<>();

  public int size() {
    return primitives.size();
  }

  public Primitive get(int index) {
    return primitives.get(index);
  }

  public void add(Primitive primitive) {
    this.primitives.add(primitive);
  }

  public boolean remove(Primitive primitive) {
    return this.primitives.remove(primitive);
  }

  public void remove(int index) {
    if(index >= 0 && index < size()) {
      this.primitives.remove(index);
    }
  }
}
