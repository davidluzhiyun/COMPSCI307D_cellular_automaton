package cellsociety.view.buttons;

import javafx.event.ActionEvent;

/**
 * @author dm396
 */
public class SaveFileButton extends GUIButton {


  public SaveFileButton(String btnText, String iconID) {
    super(btnText, iconID);
    this.setOnClickEvent(this::saveFileEvent);
  }

  private void saveFileEvent(ActionEvent actionEvent) {
    System.out.println("Save file button pressed!");
  }

}
