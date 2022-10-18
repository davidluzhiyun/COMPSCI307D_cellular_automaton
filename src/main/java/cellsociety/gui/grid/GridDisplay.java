package cellsociety.gui.grid;

import javafx.scene.layout.GridPane;

public class GridDisplay {
    GridPane pane;
    public GridDisplay(){
        //FIXME: Use resources!!!
        pane = new GridPane();
        this.populateGrid();
    }

    private void populateGrid(){
        GridCell cell = new GridCell(5);
        pane.add(cell.getGraphic(), 0, 0);
    }

    public GridPane getGrid(){
        return this.pane;
    }

}
