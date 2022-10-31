package cellsociety.view.buttons.animation_control;

import cellsociety.view.buttons.GUIButton;
import javafx.event.ActionEvent;

/**
 * @author dm396
 */
public class PlayPauseButton extends GUIButton {

  /**
   * Creates a JavaFX button with a specified graphic
   *
   * @param btnText the button's text
   * @param iconID  the RESOURCE name that maps the icon's filepath
   */
  public PlayPauseButton(String btnText, String iconID) {
    super(btnText, iconID);
    this.setOnClickEvent(this::saveFileEvent);
  }

  private void saveFileEvent(ActionEvent actionEvent) {
    System.out.println("Play/pause button pressed!");
  }
}
