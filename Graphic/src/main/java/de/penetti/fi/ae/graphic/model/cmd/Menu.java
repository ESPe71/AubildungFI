package de.penetti.fi.ae.graphic.model.cmd;

import de.penetti.fi.ae.graphic.model.Drawing;

public class Menu {
  private MenuState state = new MainMenu();

  private Drawing drawing = new Drawing();

  private void showMenu() {
    state.showMenu();
  }

  private MenuState processMenu() {
    return state.processMenu(drawing);
  }

  private void handleMenu() {
    while(state != null) {
      showMenu();
      state = processMenu();
    }
  }

  public static void main(String[] args) {
    Menu menu = new Menu();
    menu.handleMenu();
  }
}
