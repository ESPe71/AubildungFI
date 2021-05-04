package de.penetti.fi.ae.graphic.model.primitive;

import java.io.Serializable;
import java.util.Objects;

public class Vector implements Primitive, Serializable {
  private static final long serialVersionUID = 7383765293120826047L;
  private double x;
  private double y;

  public Vector() {
  }
  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }
  public Vector(Vector vector) {
    this.x = vector.x;
    this.y = vector.y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vector vector = (Vector) o;
    return Double.compare(vector.x, x) == 0 &&
           Double.compare(vector.y, y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "Vector(" + x + ", " + y + ")";
  }
}
