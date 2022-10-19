package cellsociety.alternativemodel;


import cellsociety.alternativemodel.cell.Cell;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

/**
 * This class holds two maps, one signify the current grid and
 * the updated form of the grid.
 * It is responsible for calling cells to update, knowing the position and neighbours of cells
 * @author david_luzhiyun
 */
public class GameModel {
  //class variables
  private Map<Coordinate, Cell> grid;


  // size of the grid
  private int sizeX;
  private int sizeY;

  //Assume null represents this cell
  private Cell nullHandler;
  // constructor copies a Map and set the size.
  // create a new empty map if receives null
  // ensures size >= 0
  public GameModel(Map<Coordinate,Cell> grid, int sizeX, int sizeY, Cell nullHandler){
    try {
      if (grid == null){
        this.grid = new HashMap<Coordinate,Cell>();
      }
      else {
        this.grid = new HashMap<Coordinate,Cell>(grid);
      }
      this.sizeX = sizeX;
      this.sizeY = sizeY;
      this.nullHandler = nullHandler;
      assert sizeX >= 0 && sizeY >= 0;
    }
    catch (AssertionError e){
      this.sizeX = Math.max(sizeX,0);
      this.sizeY = Math.max(sizeX,0);
    }
  }
  public GameModel(Map<Coordinate,Cell> grid, int sizeX, int sizeY){
    this(grid,sizeX,sizeY,null);
  }

  // package friendly method that gets the neighbours of a cell
  // make it private if no test is written
  Map<Coordinate,Integer> getNeighbours(int X, int Y){
    try {
      Map<Coordinate,Integer> result = new HashMap<Coordinate,Integer>();
      for (int i = Math.max(0, X-1); i <= Math.min(X + 1,sizeX); i++) {
        for (int j = Math.max(0, Y-1); j <= Math.min(Y + 1,sizeY); j++){
          Coordinate coordinate= new Coordinate(i,j);
          Cell selected = grid.get(coordinate);
          if (selected == null){
            result.put(coordinate,nullHandler.getType());
          }
          else {
            result.put(coordinate,selected.getType());
          }
        }
      }
      return result;
    }
    catch (NullPointerException e){
      System.out.println("Please initialize the nullhandler for GameModel as a cell if you wish to include null in the map");
      throw e;
    }
  }
  public void step(){
    try {
      Map<Coordinate,Cell> myFuture = new HashMap<>();
      for (int i = 0; i < sizeX; i++) {
        for (int j = 0; i < sizeY; j ++){
          Coordinate coordinate= new Coordinate(i,j);
          Cell selected = grid.get(coordinate);
          if (selected == null){
            selected = nullHandler;
          }
          myFuture.put(coordinate, selected.update(getNeighbours(i,j)));
        }
      }
      grid = new HashMap<Coordinate, Cell>(myFuture);
    }
    catch (NullPointerException e){
      System.out.println("Please initialize the nullHandler for GameModel as a cell if you wish to include null in the map");
      throw e;
    }
  }

  // Return a clone of myCurrent for looking
  // Change if you want to use other data structures
  public Map<Coordinate,Cell> lookCurrentGrid(){
    return new HashMap<Coordinate,Cell>(grid);
  }

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }
}
