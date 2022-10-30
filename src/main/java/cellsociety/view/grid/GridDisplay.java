package cellsociety.view.grid;

import cellsociety.view.GUI;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dm396
 */
public class GridDisplay {

  private GridPane pane;
  private int rows;
  private int cols;
  private int vGap;
  private int hGap;
  private int squareSize;

  private GridCellColorMap colorMap;
  private List<List<Integer>> cellStates;
  private List<List<GridCell>> cellGraphics;

  public GridDisplay(int rows, int cols) {
    pane = new GridPane();
    colorMap = new GridCellColorMap(10); //FIXME: Use game parameters

    // set gap size between cells
    vGap = GUI.properties.getGUIProperty("gridCellVGap");
    hGap = GUI.properties.getGUIProperty("gridCellHGap");
    pane.setHgap(vGap);
    pane.setVgap(hGap);

    this.rows = rows;
    this.cols = cols;

    this.initializeGrid();  //TODO:
  }

  public void updateGridVisualization(List<List<Integer>> cellStates) {
    if (cellStates.size() != rows || cellStates.get(0).size() != cols) {
      throw new RuntimeException("Updated cell state dimensions do not match!");
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        GridCell cell = cellGraphics.get(i).get(j);
        int state = cellStates.get(i).get(j);
        cell.getGraphic().setFill(colorMap.getColor(0));    //FIXME: colorIndex should be from state
      }
    }
  }

  public void initializeGrid() {
    cellGraphics = new ArrayList<List<GridCell>>();
    calculateCellDimensions();
    for (int i = 0; i < rows; i++) {
      cellGraphics.add(new ArrayList<GridCell>());

      for (int j = 0; j < cols; j++) {
        GridCell cell = new GridCell(squareSize,
            colorMap.getColor(0)); //FIXME: colorIndex should be from model
        pane.add(cell.getGraphic(), i, j);
        cellGraphics.get(i).add(cell);
      }
    }
  }

  /**
   * Calculates the optimal side length of the grid cells by choosing the smallest grid cell size
   * needed.
   */
  private void calculateCellDimensions() {
    int padding =
        Math.max(cols * vGap, rows * vGap) + 4 * GUI.properties.getGUIProperty("gridBorderOffsets");
    int gridWidth = GUI.properties.getGUIProperty("gridWidth") - padding;
    int gridHeight = GUI.properties.getGUIProperty("gridHeight") - padding;

    int squareWidth = gridWidth / cols;
    int squareHeight = gridHeight / rows;

    squareSize = Math.min(squareWidth, squareHeight);
  }

  public GridPane getGrid() {
    return this.pane;
  }

}