package de.penetti.fi.ae.graphic.model.primitive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LineTest {
  @Test
  void testDefaultConstructor() {
    Line l = new Line();
    assertEquals(new Vector(), l.getStartVector());
    assertEquals(new Vector(1, 1), l.getEndVector());
  }

  @ParameterizedTest
  @MethodSource
  void testConstructor(Vector v0, Vector v1) {
    Line l = new Line(v0, v1);
    assertEquals(v0, l.getStartVector());
    assertEquals(v1, l.getEndVector());
  }

  @ParameterizedTest
  @MethodSource
  void testCopyConstructor(Line line) {
    Line copy = new Line(line);
    assertEquals(line.getStartVector(), copy.getStartVector());
    assertEquals(line.getEndVector(), copy.getEndVector());
  }

  @ParameterizedTest
  @MethodSource("testConstructor")
  void testSetter(Vector v0, Vector v1) {
    Line l = new Line();
    l.setStartVector(v0);
    l.setEndVector(v1);
    assertEquals(v0, l.getStartVector());
    assertEquals(v1, l.getEndVector());
  }

  static Stream<Arguments> testConstructor() {
    return Stream.of(
        arguments(new Vector(.0, .0), new Vector(5, 5.3)),
        arguments(new Vector(), new Vector(9, 3.2)),
        arguments(new Vector(2, 7.4), new Vector(-3.14, 3.14)),
        arguments(new Vector(-348, -38), new Vector(9840372.72618, -98765026541.39843)),
        arguments(new Vector(874, 93), new Vector(85.392, -958.814))
    );
  }
  static Stream<Arguments> testCopyConstructor() {
    return Stream.of(
        arguments(new Line(new Vector(.0, .0), new Vector(5, 5.3))),
        arguments(new Line(new Vector(), new Vector(9, 3.2))),
        arguments(new Line(new Vector(2, 7.4), new Vector(-3.14, 3.14))),
        arguments(new Line(new Vector(-348, -38), new Vector(9840372.72618, -98765026541.39843))),
        arguments(new Line(new Vector(874, 93), new Vector(85.392, -958.814)))
    );
  }

}