package cellsociety.gui;

import cellsociety.gui.buttons.SaveFileBtn;
import cellsociety.gui.grid.GridDisplay;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GUI {
    // Properties
    public static final String GUI_ICON_PROPERTIES = "cellsociety.properties.GUIIcons";
    // Style guides
    private static final String BUTTON_STYLEGUIDE_RESOURCE = "/cellsociety/css/ButtonStyle.css";

    private BorderPane guiWindow;
    private AnchorPane gridPanel;
    private VBox leftPanel;
    private HBox bottomPanel;
    GridDisplay gridDisplay;

    private GUIPropertiesLoader props;

    public GUI(){
        props = new GUIPropertiesLoader();
    }


    public Scene setupScene(){
        // set up gui panes
        guiWindow = new BorderPane();
        gridPanel = new AnchorPane();
        bottomPanel = new HBox();
        leftPanel = new VBox();

        gridDisplay = new GridDisplay();

        guiWindow.getStyleClass().add("large-panes");
        gridPanel.getStyleClass().add("large-panes");
        bottomPanel.getStyleClass().add("large-panes");

        setupLeftPanel();


        guiWindow.setPrefSize(props.getGUIProperty("guiWidth"),
                            props.getGUIProperty("guiHeight"));

        gridPanel.setPrefSize(props.getGUIProperty("gridWidth"),
                            props.getGUIProperty("gridHeight"));
        gridPanel.getChildren().add(gridDisplay.getGrid());




        bottomPanel.setPrefSize(props.getGUIProperty("bottomPanelWidth"),
                                props.getGUIProperty("bottomPanelHeight"));

        guiWindow.setCenter(gridPanel);
        guiWindow.setBottom(bottomPanel);
        guiWindow.setLeft(leftPanel);

        Scene scene = new Scene(guiWindow, 750, 750);
        scene.getStylesheets().add(getClass().getResource(BUTTON_STYLEGUIDE_RESOURCE).toString());
        return scene;
    }

    private void setupLeftPanel(){
        leftPanel.getStyleClass().add("large-panes");
        leftPanel.setPrefSize(props.getGUIProperty("leftPanelWidth"),
                props.getGUIProperty("leftPanelHeight"));

        HBox buttonContainer = new HBox();
        LoadFileBtn loadFileButton = new LoadFileBtn();
        SaveFileBtn saveFileBtn = new SaveFileBtn("Save file", "openFileIconPath");

        buttonContainer.getChildren().addAll(loadFileButton.getBtn(),
                                             saveFileBtn.getBtn());

        leftPanel.getChildren().add(buttonContainer);
    }
}
