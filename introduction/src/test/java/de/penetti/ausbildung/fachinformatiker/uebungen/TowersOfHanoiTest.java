package de.penetti.ausbildung.fachinformatiker.uebungen;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TowersOfHanoiTest {
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 31})
  void testHanoi(int discs) {
    TowersOfHanoi towers = new TowersOfHanoi(discs);
    towers.setPrintMoves(false);
    towers.moveTowers();
    System.out.printf("Bei einer Turmhöhe von %d wurden die Scheiben %d mal bewegt.", discs, towers.getMoves());
  }
}