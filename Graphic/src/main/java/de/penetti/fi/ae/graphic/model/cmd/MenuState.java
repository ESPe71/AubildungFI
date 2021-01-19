package de.penetti.fi.ae.graphic.model.cmd;

import de.penetti.fi.ae.graphic.model.Drawing;

public interface MenuState {
  void showMenu();
  MenuState processMenu(Drawing drawing);
}
