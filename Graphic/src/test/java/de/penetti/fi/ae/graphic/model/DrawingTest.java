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

  @Test
  void testObservable() {
    int[] counter = {0, 0};
    Observer o0 = new Observer() {
      @Override
      public void update(Observable observable) {
        counter[0]++;
      }
    };
    Observer o1 = new Observer() {
      @Override
      public void update(Observable observable) {
        counter[1]++;
      }
    };

    drawing.addObserver(o0);
    drawing.add(new Vector());

    drawing.addObserver(o1);
    drawing.add(new Vector());
    drawing.remove(0);

    assertEquals(3, counter[0]);
    assertEquals(2, counter[1]);
  }
}