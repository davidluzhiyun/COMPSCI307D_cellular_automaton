package cellsociety.outdatedModelPendingDeletion;

public class CellConstructor {

  private int cellX;
  private int cellY;
  private int cellState;

  /**
   * Constructor for a cell
   *
   * @param state the state int value, alive or dead (or whatever states the simulation has)
   */
  public CellConstructor(int state) {
    cellState = state;
  }

  /**
   * Method to set state of a cell
   */
  public void setState(int state) {
    cellState = state;
  }

  /**
   * Method to get state of a cell
   */
  public int getState() {
    return cellState;
  }

  public void setCellX(int x) {
    cellX = x;
  }

  public void setCellY(int y) {
    cellY = y;
  }

  public int getCellX() {
    return cellX;
  }

  public int getCellY() {
    return cellY;
  }

}