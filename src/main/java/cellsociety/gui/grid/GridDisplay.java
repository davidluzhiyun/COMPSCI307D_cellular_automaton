package cellsociety.gui.grid;

import javafx.scene.layout.GridPane;

public class GridDisplay {
    GridPane pane;
    public GridDisplay(){
        //FIXME: Use resources!!!
        pane = new GridPane();
        pane.setHgap(3);
        pane.setVgap(3);
        this.populateGrid();
    }

    private void populateGrid(){
        //FIXME: This is a placeholder. implement real grid code.
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                GridCell cell = new GridCell(5);
                pane.add(cell.getGraphic(), i, j);
            }
        }

    }

    public GridPane getGrid(){
        return this.pane;
    }

}
