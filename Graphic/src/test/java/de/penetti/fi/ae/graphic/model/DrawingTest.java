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
    int[] counter = {0, 0, 0};
    GraphicObserver o0 = (observable, action, oldValue, newValue) -> counter[0]++;
    GraphicObserver o1 = (observable, action, oldValue, newValue) -> counter[1]++;
    GraphicObserver o2 = (observable, action, oldValue, newValue) -> {
      switch (action) {
        case "add" -> counter[2]++;
        case "remove" -> counter[2]--;
      }
    };

    drawing.addObserver(o0);
    drawing.addObserver(o2);
    drawing.add(new Vector());

    drawing.addObserver(o1);
    drawing.add(new Vector());
    drawing.remove(0);

    assertEquals(3, counter[0]);
    assertEquals(2, counter[1]);
    assertEquals(1, counter[2]);

    drawing.removeObserver(o0);
    drawing.remove(0);

    assertEquals(3, counter[0]);
    assertEquals(3, counter[1]);
    assertEquals(0, counter[2]);
  }

  @Test
  void listTest() {
    Vector v0 = new Vector();
    Vector v1 = new Vector();

    // für die equals-Methode sind v0 und v1 gleich,
    // deshalb darf die equals-Methode im remove von Drawing nicht verwendet werden,
    // sondern es muss mit == gearbeitet werden um tatsächlich das konkrete Primitive zu finden.
    // ALSO: in remove(Primitive) darf nicht die Methode List.remove(Object) verwendet werden,
    //       da sonst auch ein falsches Primitive gelöscht werden könnte

    drawing.add(v0);
    drawing.add(v1);
    drawing.remove(v0);

    assertFalse(v0 == drawing.get(0));
    assertTrue(v1 == drawing.get(0));
  }
}