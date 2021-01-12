package de.penetti.fi.ae.graphic.model.primitive;

import java.util.Objects;

public class Line implements Primitive {
  private Vector v0;
  private Vector v1;

  public Line() {
    this(new Vector(), new Vector(1, 1));
  }
  public Line(Vector v0, Vector v1) {
    this.v0 = new Vector(v0);
    this.v1 = new Vector(v1);
  }
  public Line(Line line) {
    this(line.v0, line.v1);
  }

  public Vector getStartVector() {
    return v0;
  }

  public void setStartVector(Vector v0) {
    this.v0 = new Vector(v0);
  }

  public Vector getEndVector() {
    return v1;
  }

  public void setEndVector(Vector v1) {
    this.v1 = new Vector(v1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Line line = (Line) o;
    return Objects.equals(v0, line.v0) && Objects.equals(v1, line.v1);
  }

  @Override
  public int hashCode() {
    return Objects.hash(v0, v1);
  }

  @Override
  public String toString() {
    return "Line[(" + v0.getX() + ", " + v0.getY() + "), (" + v1.getX() + ", " + v1.getY() + ")]";
  }
}
