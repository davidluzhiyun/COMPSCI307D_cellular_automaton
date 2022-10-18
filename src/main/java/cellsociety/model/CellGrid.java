package cellsociety.model;

import java.util.HashMap;

public class CellMap extends HashMap {
  private Cell[][] grid;
  public CellMap(int height, int width) {
    grid = new Cell[height][width];
  }

}
