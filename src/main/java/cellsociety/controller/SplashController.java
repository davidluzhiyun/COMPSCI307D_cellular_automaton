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
  private GUI gui;

  public void startGUIfromSplash() {
    gui = new GUI();
    mainStage.setScene(gui.setupScene());
    mainStage.setTitle("Cell Society");
    mainStage.show();
  }

  public void saveMainStage(Stage stage) {
    this.mainStage = stage;
  }

  public void saveMainScene(Scene scene) {
    this.simScene = scene;
  }

  public void setUIStyling(String s) {
    gui.buttonStyleguideResource = "/cellsociety/css/" + s;
  }

  public void setLangChosen(String s) {
    gui.languagePropsPath = "/cellsociety/ControllerResources/" + s + ".properties";
  }

}

