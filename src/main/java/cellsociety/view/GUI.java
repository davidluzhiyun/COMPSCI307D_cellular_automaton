package cellsociety.view;

import cellsociety.view.buttons.LoadFileButton;
import cellsociety.view.buttons.SaveFileButton;
import cellsociety.view.buttons.animation_control.PlayPauseButton;
import cellsociety.view.buttons.animation_control.StepForwardButton;
import cellsociety.view.grid.GridDisplay;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 * This class encapsulates the entire user interface, which includes all buttons used to interact
 * with the program as well as the entire view of the grid.
 *
 * @author dm396
 */
public class GUI {


  // Properties
  public static final String GUI_ICON_PROPERTIES = "cellsociety.properties.GUIIcons";
  // Style guides
  private static final String BUTTON_STYLEGUIDE_RESOURCE = "/cellsociety/css/JFXGraphicStyles.css";

  // Set of panels that organizes GUI elements
  private BorderPane guiWindow;
  private StackPane gridPanel;
  private VBox leftPanel;
  private HBox bottomPanel;
  private GridDisplay gridDisplay;
  private VBox gridContainer;

  public static final GUIPropertiesLoader properties = new GUIPropertiesLoader();

  public GUI() {
  }


  /**
   * Set up the scene with all JFX graphics
   *
   * @return scene
   */
  public Scene setupScene() {
    // set up gui panes
    guiWindow = new BorderPane();
    gridPanel = new StackPane();
    bottomPanel = new HBox();
    leftPanel = new VBox();
    gridContainer = new VBox();

    // style the panels
    guiWindow.getStyleClass().add("large-panes");
    bottomPanel.getStyleClass().add("large-panes");

    setupLeftPanel();
    setupRightPanel();

    // set panel dimensions
    guiWindow.setPrefSize(properties.getGUIProperty("guiWidth"),
        properties.getGUIProperty("guiHeight"));

    // sets panel positions within the larger GUI window
    guiWindow.setCenter(gridContainer);
    guiWindow.setBottom(bottomPanel);
    guiWindow.setLeft(leftPanel);

    // set up scene
    Scene scene = new Scene(guiWindow, properties.getGUIProperty("guiWidth"),
        properties.getGUIProperty("guiHeight"));
    try {
      scene.getStylesheets().add(getClass().getResource(BUTTON_STYLEGUIDE_RESOURCE).toString());
    } catch (NullPointerException e) {
      throw new NullPointerException("Resource styleguide not found.");
    }
    return scene;
  }

  /**
   * Sets up all objects in the left panel, which encompasses the load/save file buttons, color
   * pickers, and the simulation information display.
   */
  private void setupLeftPanel() {
    // set up left panel's properties
    leftPanel.getStyleClass().add("large-panes");
    leftPanel.setPrefSize(properties.getGUIProperty("leftPanelWidth"),
        properties.getGUIProperty("leftPanelHeight"));

    // organizes buttons in a horizontal container
    HBox buttonContainer = new HBox();
    LoadFileButton loadFileButton = new LoadFileButton("Load File", "openFileIconPath");
    SaveFileButton saveFileBtn = new SaveFileButton("Save File", "saveFileIconPath");

    // TODO: implement simulation info class
    SimInformationDisplay info = new SimInformationDisplay("""
        Simulation type:\tnull
        Author:\tnull
        Other info:\tnull
        """);

    // add all elements to panel group
    buttonContainer.getChildren().addAll(loadFileButton.getButton(),
        saveFileBtn.getButton());
    buttonContainer.setSpacing(properties.getGUIProperty("defaultElementSpacing"));
    leftPanel.setSpacing(properties.getGUIProperty("leftPanelVertSpacing"));
    leftPanel.setPadding(new Insets(properties.getGUIProperty("leftPanelBorderOffset")));
    leftPanel.getChildren().addAll(buttonContainer, info.getGraphic());
    VBox.setMargin(buttonContainer, new Insets(70, 0, 0, 0));


  }

  private void setupRightPanel() {
    // FIXME: use game options

    gridDisplay = new GridDisplay(10, 10);  //TODO Implement game settings
    gridDisplay.getGrid().setAlignment(Pos.CENTER);

    // Simulation title
    Text simulationTitle = new Text("Game of Life"); //FIXME: Use game settings
    simulationTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 32));

    // Apply settings and add relevant elements
    gridPanel.getChildren().add(gridDisplay.getGrid());
    gridPanel.setMinSize(properties.getGUIProperty("gridWidth"),
        properties.getGUIProperty("gridHeight"));
    StackPane.setAlignment(gridDisplay.getGrid(), Pos.CENTER);


    // bottom buttons
    HBox buttonContainer = new HBox();
    buttonContainer.setAlignment(Pos.CENTER);
//    buttonContainer.setPadding(new Insets(properties.getGUIProperty("leftPanelBorderOffset")));
    PlayPauseButton playPauseBtn = new PlayPauseButton("Play/Pause", "playpause");
    StepForwardButton stepForwardButton = new StepForwardButton("Step", "step");
    SpeedSelector speedSelector = new SpeedSelector();
    buttonContainer.getChildren().addAll(playPauseBtn.getButton(),
        speedSelector.getGraphic(),
        stepForwardButton.getButton());
    buttonContainer.setSpacing(properties.getGUIProperty("defaultElementSpacing"));


    gridContainer.getChildren().addAll(simulationTitle, gridPanel, buttonContainer);
    gridContainer.setAlignment(Pos.CENTER);
    VBox.setMargin(simulationTitle, new Insets(20, 0, 0, 0));
  }


}