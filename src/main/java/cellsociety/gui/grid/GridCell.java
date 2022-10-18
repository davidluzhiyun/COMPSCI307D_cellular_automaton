package cellsociety.gui.grid;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

import java.nio.file.Paths;

public class GridCell {

    Rectangle rectangle;
    private static final String BUTTON_STYLEGUIDE_RESOURCE = "/cellsociety/css/ButtonStyle.css";


    public GridCell(int gridDimensions){
        rectangle = new Rectangle(25, 25);
        rectangle.getStyleClass().add("rectangle");
    }

    public Rectangle getGraphic(){
        return rectangle;
    }
}
