package de.penetti.fi.ae.graphic.model.primitive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import java.util.zip.DeflaterOutputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class VectorTest {

  @Test
  void testDefaultConstructor() {
    Vector v = new Vector();
    assertEquals(.0, v.getX());
    assertEquals(.0, v.getY());
  }

  @ParameterizedTest
  @MethodSource
  void testConstructor(double x, double y) {
    Vector v = new Vector(x, y);
    assertEquals(x, v.getX());
    assertEquals(y, v.getY());
  }

  @ParameterizedTest
  @MethodSource
  void testCopyConstructor(Vector v) {
    Vector copy = new Vector(v);
    assertEquals(v.getX(), copy.getX());
    assertEquals(v.getY(), copy.getY());
  }

  @ParameterizedTest
  @MethodSource("testConstructor")
  void testSetter(double x, double y) {
    Vector v = new Vector();
    v.setX(x);
    v.setY(y);
    assertEquals(x, v.getX());
    assertEquals(y, v.getY());
  }


  static Stream<Arguments> testConstructor() {
    return Stream.of(
        arguments(.0, .0),
        arguments(1, 1.0),
        arguments(-1, -23.0),
        arguments(56482, -984736.564),
        arguments(-5876, 98675),
        arguments(-10, -10),
        arguments(Double.MAX_VALUE, Double.MIN_VALUE)
    );
  }
  static Stream<Arguments> testCopyConstructor() {
    return Stream.of(
      arguments(new Vector()),
      arguments(new Vector(.0, 0)),
      arguments(new Vector(345691, 98564)),
      arguments(new Vector(-746, -36)),
      arguments(new Vector(875, -8.32)),
      arguments(new Vector(-4873.5, 9810.06))
    );
  }
}