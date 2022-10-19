package cellsociety.alternativeModel.cell;

import cellsociety.alternativeModel.Coordinate;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract cell class
 * @author david_luzhiyun
 */
public abstract class Cell {
  // Integer type is for easy processing of the cell
  // Different types of cell in different games might share the same type integer
  protected int type;
  public Cell(){}
  // Count the number of a certain type of neighbours
  // return 0 when "neighbours" is null
  protected int countNeighbour(int type, Map<Coordinate,Integer> neighbours){
    try {
      HashMap<Coordinate,Integer> neighbours_clone = new HashMap(neighbours);
      int counter = 0;
      for (Map.Entry<Coordinate,Integer> entry: neighbours_clone.entrySet()) {
        if (entry.getValue() == type){
          counter += 1;
        }
      }
      return counter;
    }
    catch (NullPointerException e){
      return 0;
    }
  }
  // Return a cell that the current cell will be updated into
  public abstract Cell update(Map<Coordinate,Integer> neighbours);

  public int getType() {
    return type;
  }
}
