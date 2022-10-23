package cellsociety.alternativeModel;


import cellsociety.alternativeModel.cell.Cell;
import cellsociety.alternativeModel.cell.CellType;
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
  // represents the largest index, reachable
  private int maxX;
  private int maxY;

  //Assume null represents this cell
  private Cell nullHandler;
  // constructor copies a Map and set the size.
  // create a new empty map if receives null
  // ensures size >= 0
  public GameModel(Map<Coordinate,Cell> grid, int maxX, int maxY, Cell nullHandler){
    try {
      if (grid == null){
        this.grid = new HashMap<Coordinate,Cell>();
      }
      else {
        this.grid = new HashMap<Coordinate,Cell>(grid);
      }
      this.maxX = maxX;
      this.maxY = maxY;
      this.nullHandler = nullHandler;
      assert maxX >= 0 && maxY >= 0;
    }
    catch (AssertionError e){
      this.maxX = Math.max(maxX,0);
      this.maxY = Math.max(maxX,0);
    }
  }
  public GameModel(Map<Coordinate,Cell> grid, int maxX, int maxY){
    this(grid, maxX, maxY,null);
  }

  // package friendly method that gets the neighbours of a cell
  // make it private if no test is written
  Map<Coordinate, CellType> getNeighbours(int X, int Y){
    try {
      Map<Coordinate,CellType> result = new HashMap<Coordinate,CellType>();
      for (int i = Math.max(0, X-1); i <= Math.min(X + 1, maxX); i++) {
        for (int j = Math.max(0, Y-1); j <= Math.min(Y + 1, maxY); j++){
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
      result.remove(new Coordinate(X,Y));
      return result;
    }
    catch (NullPointerException e){
      System.out.println("Please initialize the nullhandler for GameModel as a cell if you wish to include null in the map");
      throw e;
    }
  }

  //Updates the grid
  public void step(){
    try {
      Map<Coordinate,Cell> myFuture = new HashMap<>();
      for (int i = 0; i <= maxX; i++) {
        for (int j = 0; j <= maxY; j ++){
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

  public int getMaxX() {
    return maxX;
  }

  public int getMaxY() {
    return maxY;
  }
}
