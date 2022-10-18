package cellsociety.alternativemodel;

import java.util.Map;

/**
 * Abstract cell class
 * @author david_luzhiyun
 */
public abstract class Cell {
  protected int type;
  public Cell(){}
  // Count the number of a certain type of neighbor
  protected int countNeighbour(int type, Map<Coordinate,Integer> neighbours){
    int counter = 0;
    for (Map.Entry<Coordinate,Integer> entry:neighbours.entrySet()) {
      if (entry.getValue() == type){
        counter += 1;
      }
    }
    return counter;
  }
  // Return a cell that the current cell will be updated into
  public abstract Cell update(Map<Coordinate,Integer> neighbours);

  public int getType() {
    return type;
  }
}
