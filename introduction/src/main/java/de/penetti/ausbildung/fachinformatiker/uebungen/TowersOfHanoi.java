package de.penetti.ausbildung.fachinformatiker.uebungen;

public class TowersOfHanoi {
  private final int discs;

  private int moves = 0;
  private boolean printMoves = true;

  public TowersOfHanoi(int discs) {
    this.discs = discs;
  }

  public void moveTowers() {
    moveTower(discs, "Quelle", "Ziel", "Hilf");
  }

  public int getMoves() {
    return moves;
  }

  public boolean isPrintMoves() {
    return printMoves;
  }

  public void setPrintMoves(boolean printMoves) {
    this.printMoves = printMoves;
  }

  private void moveDisc(int n, String von, String nach) {
    moves++;
    if(printMoves) {
      System.out.printf("Bewege Scheibe %d von %s nach %s\n", n, von, nach);
    }
  }

  private void moveTower(int n, String quelle, String ziel, String hilf) {
    if (n > 1) {
      moveTower(n - 1, quelle, hilf, ziel);
    }
    moveDisc(n, quelle, ziel);
    if (n > 1) {
      moveTower(n - 1, hilf, ziel, quelle);
    }
  }

}
