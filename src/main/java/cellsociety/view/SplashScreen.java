package cellsociety.view;

import cellsociety.Main;
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
  protected Scene SPLASH_SCENE;
  protected Group SPlASH_SCREEN_ROOT;
  protected int SPLASH_SCENE_WIDTH = 800;
  protected int SPLASH_SCENE_HEIGHT = 500;

  public SplashScreen() {
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

    // startButton.setOnAction(event -> START THE PROGRAM;
    startButton.setOnAction(event -> Main.startGUI());

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
    //engButton.setOnAction(event -> );
    engButton.setId("EnglishButton");
    languageButtons.getChildren().add(engButton);

    Button frButton = new Button("FRENCH");
    frButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //frButton.setOnAction(event -> );
    frButton.setId("FrenchButton");
    languageButtons.getChildren().add(frButton);

    Button gerButton = new Button("GERMAN");
    gerButton.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //gerButton.setOnAction(event -> );
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

    Button firstStyle = new Button("SOME UI STYLE");
    firstStyle.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //firstStyle.setOnAction(event -> );
    styleButtons.getChildren().add(firstStyle);

    Button secondStyle = new Button("SOME OTHER UI STYLE");
    secondStyle.setFont(Font.font("Futura", FontWeight.LIGHT, 15));
    //secondStyle.setOnAction(event -> );
    styleButtons.getChildren().add(secondStyle);

    return styleButtons;
  }

}