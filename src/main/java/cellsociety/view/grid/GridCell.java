package cellsociety.view.grid;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GridCell {

    private Rectangle rectangle;
    private static final String BUTTON_STYLEGUIDE_RESOURCE = "/cellsociety/css/JFXGraphicStyles.css";


    public GridCell(int squareSize, Color color){
        rectangle = new Rectangle(squareSize, squareSize);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(color);
    }

    public Rectangle getGraphic(){
        return rectangle;
    }

    public void setDefaultStyle(){

    }
}
