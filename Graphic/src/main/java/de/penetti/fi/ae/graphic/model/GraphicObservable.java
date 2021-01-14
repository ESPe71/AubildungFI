package de.penetti.fi.ae.graphic.model;


public interface GraphicObservable {
  void addObserver(GraphicObserver observer);
  void removeObserver(GraphicObserver observer);
}
