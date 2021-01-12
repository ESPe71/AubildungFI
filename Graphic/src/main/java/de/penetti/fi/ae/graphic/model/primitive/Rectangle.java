package de.penetti.fi.ae.graphic.model.primitive;

import java.util.Objects;

public class Rectangle implements Primitive {
  private Vector origin;
  private double width;
  private double height;
  private double angle; // [radians]

  public Rectangle() {
    this(new Vector(), 1, 1, 0);
  }

  public Rectangle(Vector origin, double width, double height, double angle) {
    this.origin = new Vector(origin);
    this.width = width;
    this.height = height;
    this.angle = angle;
  }

  public Rectangle(Vector origin, double width, double angle) {
    this(origin, width, width, angle);
  }

  public Rectangle(Rectangle rectangle) {
    this(rectangle.origin, rectangle.width, rectangle.height, rectangle.angle);
  }

  public Vector getOrigin() {
    return origin;
  }

  public void setOrigin(Vector origin) {
    this.origin = new Vector(origin);
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getAngle() {
    return angle;
  }

  public void setAngle(double angle) {
    this.angle = angle;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Rectangle rectangle = (Rectangle) o;
    return Double.compare(rectangle.width, width) == 0 && Double.compare(rectangle.height, height) == 0 && Double.compare(rectangle.angle, angle) == 0 && Objects.equals(origin, rectangle.origin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(origin, width, height, angle);
  }

  @Override
  public String toString() {
    return "Rectangle[(" + origin.getX() + ", " + origin.getY() + "), (" + width + ", " + height + "), " + angle + "]";
  }
}
