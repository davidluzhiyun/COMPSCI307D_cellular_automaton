package cellsociety.view;

import cellsociety.view.buttons.LoadFileButton;
import cellsociety.view.buttons.SaveFileButton;
import cellsociety.view.buttons.animation_control.AnimationPlayPauseButton;
import cellsociety.view.buttons.animation_control.AnimationSpeedSelector;
import cellsociety.view.buttons.animation_control.AnimationStepForwardButton;
import cellsociety.view.grid.GridDisplay;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;

/**
 * This class encapsulates the entire user interface, which includes all buttons
 * used to interact with the program as well as the entire view of the grid.
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
    GridDisplay gridDisplay;

    public static final GUIPropertiesLoader properties = new GUIPropertiesLoader();

    public GUI(){
    }


    /**
     * Set up the scene with all JFX graphics
     * @return scene
     */
    public Scene setupScene(){
        // set up gui panes
        guiWindow = new BorderPane();
        gridPanel = new StackPane();
        bottomPanel = new HBox();
        leftPanel = new VBox();

        // FIXME: use game options
        gridDisplay = new GridDisplay(50, 50);
        gridDisplay.getGrid().setAlignment(Pos.CENTER);
        StackPane.setAlignment(gridDisplay.getGrid(), Pos.CENTER);

        // style the panels
        guiWindow.getStyleClass().add("large-panes");
        gridPanel.getStyleClass().add("large-panes");
        bottomPanel.getStyleClass().add("large-panes");

        setupLeftPanel();
        setupBottomPanel();

        // set panel dimensions
        guiWindow.setPrefSize(properties.getGUIProperty("guiWidth"),
                            properties.getGUIProperty("guiHeight"));

        gridPanel.setMinSize(properties.getGUIProperty("gridWidth"),
                            properties.getGUIProperty("gridHeight"));
        gridPanel.getChildren().add(gridDisplay.getGrid());

        bottomPanel.setPrefSize(properties.getGUIProperty("bottomPanelWidth"),
                                properties.getGUIProperty("bottomPanelHeight"));

        // sets panel positions within the larger GUI window
        guiWindow.setCenter(gridPanel);
        guiWindow.setBottom(bottomPanel);
        guiWindow.setLeft(leftPanel);

        // set up scene
        Scene scene = new Scene(guiWindow, properties.getGUIProperty("guiWidth"),
                                            properties.getGUIProperty("guiHeight"));
        try{
            scene.getStylesheets().add(getClass().getResource(BUTTON_STYLEGUIDE_RESOURCE).toString());
        } catch(NullPointerException e){
            throw new NullPointerException("Resource styleguide not found.");
        }
        return scene;
    }

    /**
     * Sets up all objects in the left panel, which encompasses the
     * load/save file buttons, color pickers, and the simulation information display.
     */
    private void setupLeftPanel(){
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
        buttonContainer.getChildren().addAll(loadFileButton.getBtn(),
                                             saveFileBtn.getBtn());
        leftPanel.setSpacing(properties.getGUIProperty("leftPanelVertSpacing"));
        leftPanel.getChildren().addAll(buttonContainer, info.getGraphic());
    }

    private void setupBottomPanel(){
        HBox buttonContainer = new HBox();
        AnimationPlayPauseButton playPauseBtn = new AnimationPlayPauseButton("Play/Pause", "playpause");
        AnimationSpeedSelector speedSelector = new AnimationSpeedSelector("Speed", "speed");
        AnimationStepForwardButton stepForwardButton = new AnimationStepForwardButton("Step", "step");

        buttonContainer.getChildren().addAll(playPauseBtn.getBtn(),
                                            speedSelector.getBtn(),
                                            stepForwardButton.getBtn());
        bottomPanel.getChildren().add(buttonContainer);
    }

}
