package cellsociety.view.buttons;

import javafx.event.ActionEvent;

/**
 * @author dm396
 */
public class SaveFileButton extends GUIButton {

  public SaveFileButton(String btnText, String iconID) {
    super(btnText, iconID);
    this.setOnClickEvent(this::event);
  }

  private void event(ActionEvent actionEvent) {
    System.out.println("Save file button pressed!");
  }

}
