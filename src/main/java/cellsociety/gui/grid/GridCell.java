package cellsociety.gui.grid;

import javafx.scene.shape.Rectangle;

public class GridCell {

    Rectangle rectangle;
    private static final String BUTTON_STYLEGUIDE_RESOURCE = "/cellsociety/css/JFXGraphicStyles.css";


    public GridCell(int squareSize){
        rectangle = new Rectangle(squareSize, squareSize);
        rectangle.getStyleClass().add("rectangle");
    }

    public Rectangle getGraphic(){
        return rectangle;
    }
}
