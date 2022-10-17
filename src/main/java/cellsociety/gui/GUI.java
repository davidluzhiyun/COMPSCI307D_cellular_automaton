package cellsociety.gui;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class GUI {
    public static final String GUI_ICON_PROPERTIES = "cellsociety.properties.GUIIcons";
    public GUI(){

    }


    public Scene setupScene(){
        // set up gui panes
        BorderPane bPane = new BorderPane();
        AnchorPane gridPane = new AnchorPane();
        VBox leftPanel = new VBox();
        HBox bottomPanel = new HBox();

        LoadFileBtn loadFileButton = new LoadFileBtn();


        //NOTE: TEMPORARY!!! No magic values!
        gridPane.setPrefSize(400, 400);
        gridPane.setBackground(Background.fill(Color.CYAN));

        leftPanel.setPrefSize(150, 550);
        leftPanel.setBackground(Background.fill(Color.YELLOW));
        leftPanel.getChildren().add(loadFileButton.getLoadFileBtn());

        bottomPanel.setPrefSize(400, 150);
        bottomPanel.setBackground(Background.fill(Color.MAGENTA));



        bPane.setCenter(gridPane);
        bPane.setLeft(leftPanel);
        bPane.setBottom(bottomPanel);

        Scene scene = new Scene(bPane, 750, 750);

        return scene;
    }
}
