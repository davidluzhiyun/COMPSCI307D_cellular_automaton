package cellsociety.model;

import cellsociety.alternativeModel.Coordinate;
import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import java.util.List;

public class CellGrid implements GridInterface {
  private Map<Coordinate, Cell> gameGrid;

  /**
   * Constructor for cellGrid
   * @param height
   * @param width
   */
  public CellGrid(int height, int width) {
    gameGrid = new Map<>();
  }

  /**
   * Constructor for initial state cellGrid
   * @param
   * @return
   */
  public CellGrid(List[][] inputGrid) {
    makeGrid(inputGrid);
  }

  public int getGridWidth() {
    return gameGrid[0].length;
  }

  public int getGridHeight() {
    return gameGrid.length;
  }

  private void makeGrid(List[][] inputGrid) {
    int row
  }

  private Grid gameOfLifeParser(String gameOfLifeFile){
    List<String[]> gridValues = readAllDataAtOnce(gameOfLifeFile);
    //new grid
    if(gridValues == null){

    }
    //Add map of enum values
    rows = Integer.parseInt(gridValues.get(0)[0]);
    columns = Integer.parseInt(gridValues.get(0)[1]);
    DeadCell gridDefault = new DeadCell();
    Grid cellGrid = new Grid(rows, columns, gridDefault);
    for(int r = 1; r < rows + 1; r++){
      for(int c = 0; c < columns; c++){
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        if(newCellType == 0){
          cellGrid.putCellAt(r-1, c, new DeadCell());
        }
        else if(newCellType == 1){
          cellGrid.putCellAt(r-1, c, new AliveCell());
        }
      }
    }
    return cellGrid;
  }

}
