package cellsociety.controller;

import cellsociety.view.GUI;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SplashController {

  private String language;
  private Scene simScene;
  private ResourceBundle rb;
  private Stage mainStage;
  private Controller controller;

  public void startGUIfromSplash() {
    controller = new Controller();
    mainStage.setScene(controller.startGUI());
    mainStage.setTitle("Cell Society");
    mainStage.show();
  }

  public void saveMainStage(Stage stage) {
    this.mainStage = stage;
  }

  public void saveMainScene(Scene scene) {
    this.simScene = scene;
  }

  /**
   * Sets the proper UI styling desired
   * @param s, String denoting which type of styling to use
   */
  public void setUIStyling(String s) {
    controller.getSimGUI().buttonStyleguideResource = "/cellsociety/css/" + s;
  }

  /**
   * Sets the proper language desired
   * @param s, String denoting which langugae file to pick from resources
   */
  public void setLangChosen(String s) {
    controller.getSimGUI().languagePropsPath = "/cellsociety/ControllerResources/" + s + ".properties";
  }

}

