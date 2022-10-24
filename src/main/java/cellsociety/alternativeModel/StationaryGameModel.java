package cellsociety.alternativeModel;


import cellsociety.alternativeModel.cell.StationaryCell;
import cellsociety.alternativeModel.cell.CellType;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

/**
 * Applicable to Game of Life, Rock Paper Scissors, Spread of fire and other
 * CAs that doesn't involve cells moving around.
 * @author david_luzhiyun
 */
public class StationaryGameModel {
  //class variables
  private Map<Coordinate, StationaryCell> grid;


  // size of the grid
  // represents the largest index reachable
  private int maxX;
  private int maxY;

  // constructor copies a Map and set the size.
  // create a new empty map if receives null
  // ensures size >= 0
  public StationaryGameModel(Grid inputGrid){
    try {
      if (grid == null){
        this.grid = new HashMap<Coordinate, StationaryCell>();
      }
      else {
        this.grid = new HashMap<Coordinate, StationaryCell>(grid);
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
  public StationaryGameModel(Map<Coordinate, StationaryCell> grid, int maxX, int maxY){
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
          StationaryCell selected = grid.get(coordinate);
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
      Map<Coordinate, StationaryCell> myFuture = new HashMap<>();
      for (int i = 0; i <= maxX; i++) {
        for (int j = 0; j <= maxY; j ++){
          Coordinate coordinate= new Coordinate(i,j);
          StationaryCell selected = grid.get(coordinate);
          if (selected == null){
            selected = nullHandler;
          }
          myFuture.put(coordinate, selected.update(getNeighbours(i,j)));
        }
      }
      grid = new HashMap<Coordinate, StationaryCell>(myFuture);
    }
    catch (NullPointerException e){
      System.out.println("Please initialize the nullHandler for GameModel as a cell if you wish to include null in the map");
      throw e;
    }
  }

  // Return a clone of myCurrent for looking
  // Change if you want to use other data structures
  public Map<Coordinate, StationaryCell> lookCurrentGrid(){
    return new HashMap<Coordinate, StationaryCell>(grid);
  }

  public int getMaxX() {
    return maxX;
  }

  public int getMaxY() {
    return maxY;
  }
}
