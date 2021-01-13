package de.penetti.fi.ae.graphic.model;

import de.penetti.fi.ae.graphic.model.primitive.Primitive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Drawing implements Observable {
  private final List<Primitive> primitives = new ArrayList<>();
  private Collection<Observer> observers;

  public int size() {
    return primitives.size();
  }

  public Primitive get(int index) {
    return primitives.get(index);
  }

  public void add(Primitive primitive) {
    this.primitives.add(primitive);
    notifyObserver();
  }

  public boolean remove(Primitive primitive) {
    boolean b = this.primitives.remove(primitive);
    if(b) {
      notifyObserver();
    }
    return b;
  }

  public void remove(int index) {
    if(index >= 0 && index < size()) {
      this.primitives.remove(index);
      notifyObserver();
    }
  }

  @Override
  public void addObserver(Observer observer) {
    if(observers == null) {
      observers = new ArrayList<>();
    }
    if(!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  @Override
  public void removeObserver(Observer observer) {
    if(observers != null) {
      observers.remove(observer);
    }
  }

  private void notifyObserver() {
    if(observers != null) {
      observers.forEach(observer -> observer.update(this));
    }
  }
}
