package cellsociety.view;

import cellsociety.controller.Controller;
import cellsociety.controller.GameState;
import javafx.scene.Scene;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GUITest {

  private GUI gui;
  @Test
  public void makeGUI(){
    gui = new GUI(null);
    assertNotEquals(gui, null);
  }
}
