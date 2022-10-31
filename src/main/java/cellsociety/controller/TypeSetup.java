package cellsociety.controller;

import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import java.util.List;

public class TypeSetup {
  //Instead of this class just take in the information from the sim file and the type to create hashmap that
  //maps numbers to classes
  //Method that takes in type and call new abstract cell initialized from reflection based on type and number in the initial state
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
  private void watorworld(List<String[]> gridValues, Grid cellGrid,  Double gridParameter,
      int rows, int columns){
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
  private void segregation(List<String[]> gridValues, Grid cellGrid, Double gridParameter,
      int rows, int columns){
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
  private void fire(List<String[]> gridValues, Grid cellGrid,  Double gridParameter,
      int rows, int columns){
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

}
