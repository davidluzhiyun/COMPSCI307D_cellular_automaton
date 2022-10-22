package cellsociety.alternativeModel;

import cellsociety.alternativeModel.cell.Cell;
import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper around Hashmap, facilitate communication between parser
 * and model, and model to GUI
 */
public class Grid {
  // Class variables
  private int maxX;
  private int maxY;
  private Map<Coordinate, Cell> myMap;
  // Pretend null is this cell
  private Cell nullHandler;

  public Grid(int X, int Y, Cell defaultCell){
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
  //Not initializing the nullHandler
  public Grid(int X, int Y){
    this(X, Y, null);
  }

  // Gets the cell at given coordinate
  public Cell getCellAt(int X, int Y) throws AssertionError{
    try {
      assert X <= maxX && X >= 0;
      assert Y <= maxY && Y >= 0;
      Cell myCell = myMap.get(new Coordinate(X, Y));
      if (myCell == null){
        return nullHandler;
      }
      else {
        return myCell;
      }
    }
    catch (AssertionError e){
      System.out.println("Try to get a cell out of bound for Grid");
      throw e;
    }
  }
  // Gets the cell's type tag (an integer representing its type in a game) at given coordinate
  public int getTypeTagAt(int X, int Y) throws AssertionError{
    try {
      assert X <= maxX && X >= 0;
      assert Y <= maxY && Y >= 0;
      Cell myCell = myMap.get(new Coordinate(X, Y));
      if (myCell == null){
        return nullHandler.getType();
      }
      else {
        return myCell.getType();
      }
    }
    catch (AssertionError e){
      System.out.println("Try to get a cell's type tag out of bound for Grid");
      throw e;
    }

  }
  public void putCellAt(int X, int Y, Cell newCell){
    try {
      assert X <= maxX && X >= 0;
      assert Y <= maxY && Y >= 0;
      myMap.put(new Coordinate(X,Y),newCell);
    }
    catch (AssertionError e){
      // Do nothing
    }

  }

}
