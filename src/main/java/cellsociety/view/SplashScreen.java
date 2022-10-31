package cellsociety.view;

import cellsociety.Main;
import cellsociety.controller.Controller;
import cellsociety.controller.SplashController;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Splash screen class to make a splash screen to display startup options
 * Adapted from Logo splash screen right now, have to connect action events to controller methods
 * Use reflection to do this from resource files
 *
 * @author armanshekarriz
 * @author Nicki & Eloise (adapted from structure designed by team for Splash screen in Oolala)
 */

public class SplashScreen {
  public String SPLASH_TITLE;
  private Scene SPLASH_SCENE;
  private Group SPlASH_SCREEN_ROOT;
  private int SPLASH_SCENE_WIDTH = 800;
  private int SPLASH_SCENE_HEIGHT = 500;
  private SplashController splashController;

  public SplashScreen(SplashController sc) {
    splashController = sc;
    SPlASH_SCREEN_ROOT = new Group();
    SPLASH_SCENE = new Scene(SPlASH_SCREEN_ROOT, SPLASH_SCENE_WIDTH, SPLASH_SCENE_HEIGHT);
    SPLASH_TITLE = "Simulation Options";
  }

  /**
   * Make the splash screen startup
   *
   * @return Splash Screen Scene
   */
  public Scene createScene() {
    VBox v = new VBox(10);
    v.setAlignment(Pos.CENTER);

    Text title = setSplashText(SPLASH_TITLE, 40, Color.DARKMAGENTA);

    Text pickLanguageText = setSplashText("1) Select a language", 20, Color.BLACK);
    HBox languageButtons = makeLanguageButtons();

    Text pickAppText = setSplashText("2) Select a cellular automata to simulate", 20, Color.BLACK);
    HBox appButtons = makeAppButtons();

    Text pickStyleText = setSplashText("3) Select a Style", 20, Color.BLACK);
    HBox styleButtons = makeStyleOptions();

    Text startText = setSplashText("4) Click \"Start\" to launch the app", 20, Color.BLACK);
    Button startButton = new Button("Start");
    startButton.setId("StartButton");
    startButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));

    startButton.setOnAction(event -> splashController.startGUIfromSplash());

    v.getChildren().addAll(title, pickLanguageText, languageButtons,
        pickAppText, appButtons, pickStyleText,
        styleButtons, startText, startButton);

    v.setPrefSize(SPLASH_SCENE_WIDTH * 0.85, SPLASH_SCENE_HEIGHT * 0.85);
    v.setLayoutX(SPLASH_SCENE_WIDTH / 2 - v.getPrefWidth() / 2.0);
    v.setLayoutY(SPLASH_SCENE_HEIGHT / 2 - v.getPrefHeight() / 2.0);

    SPlASH_SCREEN_ROOT.getChildren().add(v);
    return SPLASH_SCENE;
  }

  /**
   * Set text on the splash screen
   *
   * @param text
   * @param fontSize
   * @param color
   * @return
   */
  public Text setSplashText(String text, int fontSize, Color color) {
    Text t = new Text(text);
    t.setFont(Font.font("Futura", fontSize));
    t.setFill(color);
    t.setTextAlignment(TextAlignment.CENTER);
    return t;
  }

  /**
   * Make buttons that provide language options
   *
   * @return language button options
   */
  public HBox makeLanguageButtons() {
    HBox languageButtons = new HBox(5);
    languageButtons.setAlignment(Pos.CENTER);

    Button engButton = new Button("ENGLISH");
    engButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    engButton.setOnAction(event -> splashController.setLangChosen("English"));
    engButton.setId("EnglishButton");
    languageButtons.getChildren().add(engButton);

    Button spButton = new Button("SPANISH");
    spButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    spButton.setOnAction(event -> splashController.setLangChosen("Spanish"));
    spButton.setId("FrenchButton");
    languageButtons.getChildren().add(spButton);

    Button gerButton = new Button("GERMAN");
    gerButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    gerButton.setOnAction(event -> splashController.setLangChosen("German"));
    gerButton.setId("GermanButton");
    languageButtons.getChildren().add(gerButton);

    return languageButtons;
  }

  /**
   * Make the buttons that allow users to select from all the Cellular Automata before loading GUI
   *
   * @return Application Buttons
   */
  public HBox makeAppButtons() {
    HBox appButtons = new HBox(5);
    appButtons.setAlignment(Pos.CENTER);

    Button gameOfLifeButton = new Button("Game Of Life");
    gameOfLifeButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //gameOfLifeButton.setOnAction(event -> );
    gameOfLifeButton.setId("App1Button");
    appButtons.getChildren().add(gameOfLifeButton);

    Button spreadingFireButton = new Button("Spreading Fire");
    spreadingFireButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //spreadingFireButton.setOnAction(event -> );
    spreadingFireButton.setId("App2Button");
    appButtons.getChildren().add(spreadingFireButton);

    Button segregationButton = new Button("Segregation");
    segregationButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //segregationButton.setOnAction(event -> );
    segregationButton.setId("App3Button");
    appButtons.getChildren().add(segregationButton);

    Button WaTorButton = new Button("Wa-Tor World");
    WaTorButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //WaTorButton.setOnAction(event -> );
    WaTorButton.setId("App4Button");
    appButtons.getChildren().add(WaTorButton);

    Button RockPaperScissorsButton = new Button("Rock Paper Scissors");
    RockPaperScissorsButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //RockPaperScissorsButton.setOnAction(event -> );
    RockPaperScissorsButton.setId("App5Button");
    appButtons.getChildren().add(RockPaperScissorsButton);

    return appButtons;
  }

  /**
   * Make buttons for style and UI design choices, based on CSS styling
   *
   * @return CSS style choice buttons
   */
  public HBox makeStyleOptions() {
    HBox styleButtons = new HBox(5);
    styleButtons.setAlignment(Pos.CENTER);

    Button firstStyle = new Button("Dark UI");
    firstStyle.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    firstStyle.setOnAction(event -> splashController.setUIStyling("DarkTheme.css"));
    styleButtons.getChildren().add(firstStyle);

    Button secondStyle = new Button("LightTheme");
    secondStyle.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    secondStyle.setOnAction(event -> splashController.setUIStyling("LightTheme.css"));
    styleButtons.getChildren().add(secondStyle);

    return styleButtons;
  }

}
