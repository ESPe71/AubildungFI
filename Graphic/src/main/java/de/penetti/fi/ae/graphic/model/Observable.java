package de.penetti.fi.ae.graphic.model;


public interface Observable {
  void addObserver(Observer observer);
  void removeObserver(Observer observer);
}
