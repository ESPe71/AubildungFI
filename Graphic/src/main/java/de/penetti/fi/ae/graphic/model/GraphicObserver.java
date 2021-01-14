package de.penetti.fi.ae.graphic.model;

public interface GraphicObserver {
  void update(GraphicObservable observable, String action, Object oldValue, Object newValue);
}
