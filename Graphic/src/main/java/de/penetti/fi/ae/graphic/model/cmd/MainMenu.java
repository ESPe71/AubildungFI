package de.penetti.fi.ae.graphic.model.cmd;

import de.penetti.fi.ae.graphic.model.Drawing;

import java.util.Scanner;

public class MainMenu implements MenuState {
  @Override
  public void showMenu() {
    System.out.println("(1) Zeichnung neu");
    System.out.println("(2) Zeichnung laden");
    System.out.println("(x) Programm beenden");
  }

  @Override
  public MenuState processMenu(Drawing drawing) {
    MenuState state = null;
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      String input = scanner.nextLine();
      switch (input) {
        case "1": state = new DrawableMenu();
                  exit = true;
          break;
        case "2":
          break;
        case "x": exit = true;
                  state = null;
          break;
      }
    }
    return state;
  }
}
