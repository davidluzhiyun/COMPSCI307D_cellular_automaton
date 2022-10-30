package cellsociety.view.buttons;

import cellsociety.view.FileChooser;
import javafx.event.ActionEvent;

import static java.lang.Integer.parseInt;

/**
 * @author dm396
 */
public class LoadFileButton extends GUIButton {

  private FileChooser fileChooser;

  public LoadFileButton(String btnText, String iconID) {
    super(btnText, iconID);

    fileChooser = FileChooser.getInstance();
    this.setOnClickEvent(this::openFileChooser);
  }

  private void openFileChooser(ActionEvent e) {
    System.out.println("File opener prompted...");
    fileChooser.promptFileChooser();
  }


}
