package cellsociety.alternativeModel;

import cellsociety.alternativeModel.cell.AbstractCell;
import cellsociety.alternativeModel.cell.CellType;
import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper around Hashmap, facilitate communication between parser
 * and model, and model to GUI
 * Does most of the error handling for model by regulating the input
 * @author david_luzhiyun
 */
public class Grid {
  // Class variables
  private int maxX;
  private int maxY;
  private Map<Coordinate, AbstractCell> myMap;
  // Pretend null is this cell
  private AbstractCell nullHandler;

  public Grid(int X, int Y, AbstractCell defaultCell){
    try {
      maxX = X;
      maxY = Y;
      myMap = new HashMap<>();
      nullHandler = defaultCell;
      assert maxX >= 0 && maxY >= 0;
    }
    catch (AssertionError e){
      maxX = Math.max(maxX,0);
      maxY = Math.max(maxX,0);
    }
  }
  // Not initializing the nullHandler
  public Grid(int X, int Y){
    this(X, Y, null);
  }


  // Gets the cell at given coordinate
  // return null if nullHandler is null and try to get a coordinate corresponding to null
  public AbstractCell getCellAt(int X, int Y) throws AssertionError{
    try {
      assert X <= maxX && X >= 0;
      assert Y <= maxY && Y >= 0;
      AbstractCell myCell = myMap.get(new Coordinate(X, Y));
      if (myCell == null){

        try {
          assert nullHandler != null;
        }
        catch (AssertionError e){
          System.out.println("Uninitialized Cell");
          throw e;
        }

        return nullHandler;
      }
      else {
        return myCell;
      }
    }
    catch (AssertionError e){
      System.out.println("Tried to get a cell out of bound for Grid");
      throw e;
    }
  }
  // Gets the cell's type at given coordinate
  public CellType getTypeTagAt(int X, int Y) throws AssertionError, NullPointerException{
    try {
      AbstractCell myCell = this.getCellAt(X, Y);
      return myCell.getType();
    }
    catch (AssertionError e){
      System.out.println("Tried to get a cell's type tag out of bound for Grid");
      throw e;
    }
  }

  // Put a cell at given position
  public void putCellAt(int X, int Y, AbstractCell newCell){
    try {
      assert X <= maxX && X >= 0;
      assert Y <= maxY && Y >= 0;
      myMap.put(new Coordinate(X,Y),newCell);
    }
    catch (AssertionError e){
      // Do nothing
    }
  }

  public int getMaxX() {
    return maxX;
  }

  public int getMaxY() {
    return maxY;
  }
}
