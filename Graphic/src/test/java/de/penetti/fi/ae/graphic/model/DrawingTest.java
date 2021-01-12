package de.penetti.fi.ae.graphic.model;

import de.penetti.fi.ae.graphic.model.primitive.Line;
import de.penetti.fi.ae.graphic.model.primitive.Primitive;
import de.penetti.fi.ae.graphic.model.primitive.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawingTest {
  Drawing drawing;

  @BeforeEach
  void beforeEach() {
    drawing = new Drawing();
  }


  @Test
  void testAddAndGet() {
    Vector v = new Vector();

    drawing.add(v);
    Primitive p = drawing.get(0);

    assertEquals(v, p);
  }

  @Test
  void testSize() {
    assertEquals(0, drawing.size());

    drawing.add(new Vector());
    drawing.add(new Vector());
    drawing.add(new Line());

    assertEquals(3, drawing.size());
  }

  @Test
  void testRemoveByIndex() {
    drawing.add(new Vector());
    drawing.add(new Vector());
    drawing.add(new Line());

    drawing.remove(2);

    assertEquals(2, drawing.size());
  }

  @Test
  void testRemoveByPrimitive() {
    Line l = new Line();
    drawing.add(new Vector());
    drawing.add(new Vector());
    drawing.add(l);

    drawing.remove(l);

    assertEquals(2, drawing.size());
  }
}