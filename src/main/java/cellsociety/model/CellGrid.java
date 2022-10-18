package cellsociety.model;

public class CellGrid {
  private CellConstructor[][] grid;

  public CellGrid(int height, int width) {
    grid = new CellConstructor[height][width];
  }

}
