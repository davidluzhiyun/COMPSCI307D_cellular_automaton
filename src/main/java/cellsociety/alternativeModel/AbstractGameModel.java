package cellsociety.alternativeModel;

import cellsociety.alternativeModel.cell.AbstractCell;
import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.EmptyCell;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Abstract Game Model, initialize with a grid, and output a grid. Has
 * two methods. One for updating one for outputting result.
 * @author david_luzhiyun
 */

public abstract class AbstractGameModel {
  public static final String DEFAULT_RESOURCE_PACKAGE = "cellsociety.properties.";
  public static final String DEFAULT_ERRORS_RESOURCE_PACKAGE = DEFAULT_RESOURCE_PACKAGE + "ModelErrors";
  //class variables
  private Map<Coordinate, AbstractCell> grid;
  private ResourceBundle myErrorResources;


  // size of the grid
  // represents the largest index, reachable
  private int maxX;
  private int maxY;

  public AbstractGameModel(Grid inputGrid) throws NullPointerException{
    try {
      myErrorResources  = ResourceBundle.getBundle(DEFAULT_ERRORS_RESOURCE_PACKAGE);
      maxX = inputGrid.getMaxX();
      maxY = inputGrid.getMaxY();
      grid = new HashMap<>();
      for (int i = 0; i <= inputGrid.getMaxX(); i++) {
        for (int j = 0; j <= inputGrid.getMaxY(); j++) {
          grid.put(new Coordinate(i,j), inputGrid.getCellAt(i,j));
        }
      }
    }
    catch (NullPointerException e){
      System.out.println(myErrorResources.getString("inputNull"));
      throw e;
    }
  }

  // Get the cell type of the Moore Neighbourhood, defaults to empty
  protected Map<Coordinate, CellType> getMooreNeighbours(int X, int Y){
    Map<Coordinate,CellType> result = new HashMap<>();
    for (int i = Math.max(0, X-1); i <= Math.min(X + 1, maxX); i++) {
      for (int j = Math.max(0, Y-1); j <= Math.min(Y + 1, maxY); j++){
        result.put(new Coordinate(i,j),safeGetCellTypeAt(i, j));
      }
    }
    result.remove(new Coordinate(X,Y));
    return result;
  }

  // Auxiliary method for getting neighbours, doesn't screen against out of bound getting
  // because it is handled in the get neighbour methods
  private CellType safeGetCellTypeAt(int X, int Y) {
    AbstractCell selected = grid.get(new Coordinate(X,Y));
    if (selected == null){
      return CellType.EMPTY;
    }
    else {
      return selected.getType();
    }
  }

  // Get the cell type of the Von Neumann Neighbourhood, defaults to empty
  protected Map<Coordinate, CellType> getVonNeumannNeighbours(int X, int Y){
    Map<Coordinate,CellType> result = new HashMap<>();
    for (int i = Math.max(0, X-1); i <= Math.min(X + 1, maxX); i++) {
      result.put(new Coordinate(i,Y),safeGetCellTypeAt(i,Y));
    }
    for (int j = Math.max(0, Y-1); j <= Math.min(Y + 1, maxY); j++){
      result.put(new Coordinate(X,j),safeGetCellTypeAt(X, j));
    }
    result.remove(new Coordinate(X,Y));
    return result;
  }

  // Get the cell at given coordinates, might return null for some non-stationary CA
  // Screens against out of bound get attempts
  protected AbstractCell getCellAt(int X, int Y){
    try {
      assert X <= maxX && X >= 0;
      assert Y <= maxY && Y >= 0;
      return grid.get(new Coordinate(X,Y));
    }
    catch (AssertionError e){
      System.out.println(myErrorResources.getString("outOfBound"));
      throw e;
    }

  }

  // Put a cell at give coordinates, doesn't screen against null, out of bound
  // put attempts will have no effect
  protected void putCellAt(int X, int Y, AbstractCell cell){
    try {
      assert X <= maxX && X >= 0;
      assert Y <= maxY && Y >= 0;
      grid.put(new Coordinate(X, Y), cell);
    }
    catch (AssertionError e){
      //do nothing
    }
  }

  // A way to completely set a new Map as grid. Screens against null input
  protected void setGrid(Map<Coordinate, AbstractCell> newGrid){
    try {
      assert newGrid != null;
      grid = new HashMap<>(newGrid);
    }
    catch (AssertionError e){
      System.out.println(myErrorResources.getString("inputNull"));
      throw e;
    }
  }
  public abstract void step();

  // Used to look at the Current Grid
  // defaults to empty cell if the coordinate holds null
  public ImmutableTypeGrid lookCurrentGrid(){
    Grid output = new Grid(maxX,maxY);
    for (int i = 0; i <= maxX; i++) {
      for (int j = 0; j <= maxY; j++) {
        AbstractCell myCell = grid.get(new Coordinate(i,j));
        if (myCell == null){
          myCell = new EmptyCell();
        }
        output.putCellAt(i,j,myCell);
      }
    }
    return output;
  }

  // Getters for passing this info to subclasses, where it is needed for updating
  // No error handling because Grid already rules out invalid maxX maxY's
  public int getMaxX() {
    return maxX;
  }

  public int getMaxY() {
    return maxY;
  }
  // Getter for passing the ResourceBundles to subclasses

  public ResourceBundle getMyErrorResources() {
    return myErrorResources;
  }
}
