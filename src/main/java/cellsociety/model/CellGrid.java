package cellsociety.model;

import java.util.List;

public class CellGrid {
  private Cell[][] grid;

  public CellGrid(int height, int width) {
    grid = new Cell[height][width];
  }

}
