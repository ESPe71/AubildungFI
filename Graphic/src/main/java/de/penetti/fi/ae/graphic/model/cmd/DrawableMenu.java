package de.penetti.fi.ae.graphic.model.cmd;

import de.penetti.fi.ae.graphic.model.Drawing;

import java.util.Scanner;

public class DrawableMenu implements MenuState {
  @Override
  public void showMenu() {
    System.out.println("(1) Hinzufügen");
    System.out.println("(2) Entfernen");
    System.out.println("(3) Anzeigen");
    System.out.println("(x) Zurück");
  }

  @Override
  public MenuState processMenu(Drawing drawing) {
    MenuState state = null;
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      String input = scanner.nextLine();
      switch (input) {
        case "1":
          break;
        case "2":
          break;
        case "3": showDrawing(drawing);
          break;
        case "x": exit = true;
          state = new MainMenu();
          break;
      }
    }
    return state;
  }

  private void showDrawing(Drawing drawing) {
    System.out.println("\n\n Die Zeichnung enthält folgende Elemente: ");
    for(int i = 0; i < drawing.size(); i++) {
      System.out.println(drawing.get(i));
    }
  }
}
