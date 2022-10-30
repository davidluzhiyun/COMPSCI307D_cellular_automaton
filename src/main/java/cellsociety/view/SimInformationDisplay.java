package cellsociety.view;

import javafx.scene.text.Text;

public class SimInformationDisplay {

  private Text text;

  public SimInformationDisplay(String txt) {
    text = new Text(txt);
  }

  public Text getGraphic() {
    return text;
  }
}
