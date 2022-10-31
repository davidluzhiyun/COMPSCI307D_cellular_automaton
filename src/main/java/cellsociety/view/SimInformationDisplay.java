package cellsociety.view;

import cellsociety.controller.Controller;
import javafx.scene.text.Text;

public class SimInformationDisplay {

  private Text text;

  public SimInformationDisplay(String gameType, String gameTitle, String gameAuthor, String gameDescription) {

    text = new Text("Game type: " + gameType + "\n" +
        "Title: " + gameTitle + "\n" +
        "Author: " + gameAuthor + "\n" +
        "Description: " + gameDescription + "\n");
  }

  public Text getGraphic() {
    return text;
  }

}
