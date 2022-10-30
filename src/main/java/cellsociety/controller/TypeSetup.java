package cellsociety.parsing;

import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import java.util.List;

public class TypeSetup {
  private void gameoflife(List<String[]> gridValues, Grid cellGrid, Double gridParameter, int rows, int columns){
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        switch(newCellType){
          case(1):
            cellGrid.putCellAt(r - 1, c, new AliveCell());
          default:
            cellGrid.putCellAt(r - 1, c, new DeadCell());
        }
      }
    }
  }

  private void percolation(List<String[]> gridValues, Grid cellGrid,  Double gridParameter,
      int rows, int columns){

  }
  private void watorworld(List<String[]> gridValues, Grid cellGrid,  Double gridParameter,
      int rows, int columns){

  }
  private void segregation(List<String[]> gridValues, Grid cellGrid, Double gridParameter,
      int rows, int columns){

  }
  private void fire(List<String[]> gridValues, Grid cellGrid,  Double gridParameter,
      int rows, int columns){

  }

}
