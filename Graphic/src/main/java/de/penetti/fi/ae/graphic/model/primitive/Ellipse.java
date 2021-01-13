package de.penetti.fi.ae.graphic.model.primitive;

import java.util.Objects;

public class Ellipse implements Primitive {
  private Vector center;
  private double xRadius;
  private double yRadius;
  private double angle; // [radians]

  public Ellipse() {
    this(new Vector(), 1., 1.,.0);
  }

  public Ellipse(Vector center, double xRadius, double yRadius, double angle) {
    this.center = new Vector(center);
    this.xRadius = xRadius;
    this.yRadius = yRadius;
    this.angle = angle;
  }

  public Ellipse(Vector center, double radius) {
    this(center, radius, radius, .0);
  }

  public Ellipse(Ellipse ellipse) {
    this(ellipse.center, ellipse.xRadius, ellipse.yRadius, ellipse.angle);
  }

  public Vector getCenter() {
    return center;
  }

  public void setCenter(Vector center) {
    this.center = new Vector(center);
  }

  public double getXRadius() {
    return xRadius;
  }

  public void setXRadius(double xRadius) {
    this.xRadius = xRadius;
  }

  public double getYRadius() {
    return yRadius;
  }

  public void setYRadius(double yRadius) {
    this.yRadius = yRadius;
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
    Ellipse ellipse = (Ellipse) o;
    return Double.compare(ellipse.xRadius, xRadius) == 0 &&
           Double.compare(ellipse.yRadius, yRadius) == 0 &&
           Double.compare(ellipse.angle, angle) == 0 &&
           Objects.equals(center, ellipse.center);
  }

  @Override
  public int hashCode() {
    return Objects.hash(center, xRadius, yRadius, angle);
  }

  @Override
  public String toString() {
    return "Ellipse[(" + center.getX() + ", " + center.getY() + "), (" + xRadius + ", " + yRadius + "), " + angle + "]";
  }
}
