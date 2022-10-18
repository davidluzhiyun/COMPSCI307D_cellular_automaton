package cellsociety.gui;

import cellsociety.gui.buttons.LoadFileBtn;
import cellsociety.gui.buttons.SaveFileBtn;
import cellsociety.gui.buttons.animation_control.AnimationPlayPauseBtn;
import cellsociety.gui.buttons.animation_control.AnimationSpeedSelector;
import cellsociety.gui.buttons.animation_control.AnimationStepForwardButton;
import cellsociety.gui.grid.GridDisplay;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This class encapsulates the entire user interface, which includes all buttons
 * used to interact with the program as well as the entire view of the grid.
 */
public class GUI {
    // Properties
    public static final String GUI_ICON_PROPERTIES = "cellsociety.properties.GUIIcons";
    // Style guides
    private static final String BUTTON_STYLEGUIDE_RESOURCE = "/cellsociety/css/JFXGraphicStyles.css";

    // Set of panels that organizes GUI elements
    private BorderPane guiWindow;
    private AnchorPane gridPanel;
    private VBox leftPanel;
    private HBox bottomPanel;
    GridDisplay gridDisplay;

    private GUIPropertiesLoader props;

    public GUI(){
        props = new GUIPropertiesLoader();
    }


    /**
     * Set up the scene with all JFX graphics
     * @return scene
     */
    public Scene setupScene(){
        // set up gui panes
        guiWindow = new BorderPane();
        gridPanel = new AnchorPane();
        bottomPanel = new HBox();
        leftPanel = new VBox();

        gridDisplay = new GridDisplay();

        // style the panels
        guiWindow.getStyleClass().add("large-panes");
        gridPanel.getStyleClass().add("large-panes");
        bottomPanel.getStyleClass().add("large-panes");

        setupLeftPanel();
        setupBottomPanel();

        // set panel dimensions
        guiWindow.setPrefSize(props.getGUIProperty("guiWidth"),
                            props.getGUIProperty("guiHeight"));

        gridPanel.setPrefSize(props.getGUIProperty("gridWidth"),
                            props.getGUIProperty("gridHeight"));
        gridPanel.getChildren().add(gridDisplay.getGrid());

        // FIXME with resources
        gridDisplay.getGrid().setLayoutX(20);
        gridDisplay.getGrid().setLayoutY(40);


        bottomPanel.setPrefSize(props.getGUIProperty("bottomPanelWidth"),
                                props.getGUIProperty("bottomPanelHeight"));

        // sets panel positions within the larger GUI window
        guiWindow.setCenter(gridPanel);
        guiWindow.setBottom(bottomPanel);
        guiWindow.setLeft(leftPanel);

        // set up scene
        Scene scene = new Scene(guiWindow, 750, 750);
        scene.getStylesheets().add(getClass().getResource(BUTTON_STYLEGUIDE_RESOURCE).toString());
        return scene;
    }

    /**
     * Sets up all objects in the left panel, which encompasses the
     * load/save file buttons, color pickers, and the simulation information display.
     */
    private void setupLeftPanel(){
        // set up left panel's properties
        leftPanel.getStyleClass().add("large-panes");
        leftPanel.setPrefSize(props.getGUIProperty("leftPanelWidth"),
                props.getGUIProperty("leftPanelHeight"));

        // organizes buttons in a horizontal container
        HBox buttonContainer = new HBox();
        LoadFileBtn loadFileButton = new LoadFileBtn("Load File", "openFileIconPath");
        SaveFileBtn saveFileBtn = new SaveFileBtn("Save File", "saveFileIconPath");

        // TODO: implement simulation info class
        SimInformationDisplay info = new SimInformationDisplay("""
                Simulation type:\tnull
                Author:\tnull
                Other info:\tnull
                """);

        // add all elements to panel group
        buttonContainer.getChildren().addAll(loadFileButton.getBtn(),
                                             saveFileBtn.getBtn());
        leftPanel.setSpacing(props.getGUIProperty("leftPanelVertSpacing"));
        leftPanel.getChildren().addAll(buttonContainer, info.getGraphic());
    }

    private void setupBottomPanel(){
        HBox buttonContainer = new HBox();
        AnimationPlayPauseBtn playPauseBtn = new AnimationPlayPauseBtn("Play/Pause", "playpause");
        AnimationSpeedSelector speedSelector = new AnimationSpeedSelector("Speed", "speed");
        AnimationStepForwardButton stepForwardButton = new AnimationStepForwardButton("Step", "step");

        buttonContainer.getChildren().addAll(playPauseBtn.getBtn(),
                                            speedSelector.getBtn(),
                                            stepForwardButton.getBtn());
        bottomPanel.getChildren().add(buttonContainer);
    }
}
