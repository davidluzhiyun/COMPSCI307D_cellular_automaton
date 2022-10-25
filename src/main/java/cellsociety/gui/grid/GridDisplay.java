package cellsociety.gui.grid;

import cellsociety.gui.GUI;
import javafx.scene.layout.GridPane;

/**
 * @author dm396
 */
public class GridDisplay {
    GridPane pane;
    public GridDisplay(int width, int height){
        pane = new GridPane();
        pane.setHgap(GUI.properties.getGUIProperty("gridCellHGap"));
        pane.setVgap(GUI.properties.getGUIProperty("gridCellVGap"));
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
