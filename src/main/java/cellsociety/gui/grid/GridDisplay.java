package cellsociety.gui.grid;

import cellsociety.gui.GUI;
import javafx.scene.layout.GridPane;

/**
 * @author dm396
 */
public class GridDisplay {
    GridPane pane;
    private int rows;
    private int cols;
    private int vGap;
    private int hGap;
    private int squareSize;
    public GridDisplay(int rows, int cols){
        pane = new GridPane();

        // set gap size between cells
        vGap = GUI.properties.getGUIProperty("gridCellVGap");
        hGap = GUI.properties.getGUIProperty("gridCellHGap");
        pane.setHgap(vGap);
        pane.setVgap(hGap);

        this.rows = rows;
        this.cols = cols;

        this.populateGrid();
    }

    private void populateGrid(){
        //FIXME: This is a placeholder. implement real grid code.
        calculateCellDimensions();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                GridCell cell = new GridCell(squareSize);
                pane.add(cell.getGraphic(), i, j);
            }
        }

    }

    /**
     * Calculates the optimal side length of the grid cells by choosing the
     * smallest grid cell size needed.
     */
    private void calculateCellDimensions(){
        int padding = Math.max(cols*vGap, rows*vGap)/2 + 2*GUI.properties.getGUIProperty("gridBorderOffsets");
        int gridWidth = GUI.properties.getGUIProperty("gridWidth") - padding;
        int gridHeight = GUI.properties.getGUIProperty("gridHeight") - padding;

        int squareWidth = gridWidth/cols;
        int squareHeight = gridHeight/rows;

        squareSize = Math.min(squareWidth, squareHeight);
    }

    public GridPane getGrid(){
        return this.pane;
    }

}
