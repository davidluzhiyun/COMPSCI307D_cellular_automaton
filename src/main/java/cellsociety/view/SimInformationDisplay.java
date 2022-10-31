package cellsociety.view;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SimInformationDisplay {

  private Text text;

  public SimInformationDisplay(String gameType, String gameTitle, String gameAuthor, String gameDescription) {

    text = new Text("Game type: " + gameType + "\n" +
        "Title: " + gameTitle + "\n" +
        "Author: " + gameAuthor + "\n" +
        "Description: " + gameDescription + "\n");
    text.setFont(Font.font("Helvetica"));
  }

  public Text getGraphic() {
    return text;
  }
}
