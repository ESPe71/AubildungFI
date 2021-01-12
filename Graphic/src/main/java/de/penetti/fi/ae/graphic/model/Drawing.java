package de.penetti.fi.ae.graphic.model;

import de.penetti.fi.ae.graphic.model.primitive.Primitive;

import java.util.ArrayList;
import java.util.List;

public class Drawing {
  private List<Primitive> primitive = new ArrayList<>();

  public int size() {
    return primitive.size();
  }

  public Primitive get(int index) {
    return primitive.get(index);
  }

  public void add(Primitive primitive) {
    this.primitive.add(primitive);
  }

  public void remove(Primitive primitive) {
    this.primitive.remove(primitive);
  }

  public void remove(int index) {
    if(index < size()) {
      this.primitive.remove(index);
    }
  }
}
