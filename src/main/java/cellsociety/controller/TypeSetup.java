package cellsociety.controller;

import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import java.util.List;

/**
 * The class TypeSetup is used to create the different cell grid formats depending on the type of
 * game. Currently, only the Game of Life construction is somewhat correct, as the lack of cell
 * types besides the Alive and Dead cells of the Game of Life type makes creating grids for the
 * other games more difficult. However, with expansion to include these cell types assembling the
 * different grids would be possible.
 */
public class TypeSetup {

  private void gameoflife(List<String[]> gridValues, Grid cellGrid, Double gridParameter, int rows,
      int columns) {
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        if (newCellType == 1) {
          cellGrid.putCellAt(r - 1, c, new AliveCell());
        }
        cellGrid.putCellAt(r - 1, c, new DeadCell());
      }
    }
  }

  private void percolation(List<String[]> gridValues, Grid cellGrid, Double gridParameter,
      int rows, int columns) {
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        switch (newCellType) {
          case (2):
            //cellGrid.putCellAt(r - 1, c, new BlockedCell());
          case (1):
            //cellGrid.putCellAt(r - 1, c, new PercolatedCell());
          default:
            //cellGrid.putCellAt(r - 1, c, new OpenCell());
        }
      }
    }
  }

  private void watorworld(List<String[]> gridValues, Grid cellGrid, Double gridParameter,
      int rows, int columns) {
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        switch (newCellType) {
          case (2):
            //cellGrid.putCellAt(r - 1, c, new SharkCell());
          case (1):
            //cellGrid.putCellAt(r - 1, c, new FishCell());
          default:
            //cellGrid.putCellAt(r - 1, c, new OceanCell());
        }
      }
    }
  }

  private void segregation(List<String[]> gridValues, Grid cellGrid, Double gridParameter,
      int rows, int columns) {
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        switch (newCellType) {
          case (2):
            //cellGrid.putCellAt(r - 1, c, new Agent2Cell().satisfaction(gridParameter));
          case (1):
            //cellGrid.putCellAt(r - 1, c, new Agent1Cell().satisfaction(gridParameter));
          default:
            //cellGrid.putCellAt(r - 1, c, new NoAgentCell().satisfaction(gridParameter));
        }
      }
    }
  }

  private void fire(List<String[]> gridValues, Grid cellGrid, Double gridParameter,
      int rows, int columns) {
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        switch (newCellType) {
          case (2):
            //cellGrid.putCellAt(r - 1, c, new BurningCell().probBurn(gridParameter));
          case (1):
            //cellGrid.putCellAt(r - 1, c, new TreeCell().probBurn(gridParameter));
          default:
            //cellGrid.putCellAt(r - 1, c, new EmptyCell());
        }
      }
    }
  }

  private void rockpaperscissor(List<String[]> gridValues, Grid cellGrid, Double gridParameter,
      int rows, int columns) {
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        switch (newCellType) {
          case (2):
            //cellGrid.putCellAt(r - 1, c, new RockCell());
          case (1):
            //cellGrid.putCellAt(r - 1, c, new PaperCell());
          default:
            //cellGrid.putCellAt(r - 1, c, new ScissorCell());
        }
      }
    }
  }
}
