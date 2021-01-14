package de.penetti.fi.ae.graphic.model;

import de.penetti.fi.ae.graphic.model.primitive.Primitive;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Drawing implements GraphicObservable {
  private final List<Primitive> primitives = new ArrayList<>();
  private Collection<GraphicObserver> observers;

  public int size() {
    return primitives.size();
  }

  public Primitive get(int index) {
    return primitives.get(index);
  }

  public void add(Primitive primitive) {
    if(primitive != null) {
      this.primitives.add(primitive);
      notifyObserver("add", null, primitive);
    }
  }

  public void remove(Primitive primitive) {
    for(int i = 0; i < primitives.size(); i++) {
      // equals könnte ein falsches Primitive finden, deshalb wird mit == verglichen
      if(primitive == primitives.get(i)) {
        remove(i);
        break;
      }
    }
  }

  public void remove(int index) {
    if(index >= 0 && index < size()) {
      Primitive primitive = this.primitives.remove(index);
      notifyObserver("remove", primitive, null);
    }
  }

  @Override
  public void addObserver(GraphicObserver observer) {
    if(observers == null) {
      observers = new ArrayList<>();
    }
    if(!observers.contains(observer)) {
      observers.add(observer);
    }
  }

  @Override
  public void removeObserver(GraphicObserver observer) {
    if(observers != null) {
      observers.remove(observer);
    }
  }

  private void notifyObserver(String action, Object oldValue, Object newValue) {
    if(observers != null) {
      observers.forEach(observer -> observer.update(this, action, oldValue, newValue));
    }
  }
}
