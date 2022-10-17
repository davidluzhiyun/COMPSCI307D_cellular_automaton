package cellsociety;

import java.util.HashMap;
import java.util.List;

public class CellMapCreator {

  public static final int DEAD = 0;
  public static final int ALIVE = 1;

  /**
   * Still need to add how we are going to iterate over all the cells in the file that are alive,
   * although we could just create a new cell map for every coordinate and then update it for the ones
   * that are alive
   * @return
   */
  protected static HashMap<Cell, Integer> CreateMap(List<Cell> cells){
    HashMap<Cell, Integer> CellMap = new HashMap<>();
    for(Cell newCell : cells){
      CellMap.put(newCell, ALIVE);
    }
    return CellMap;
  }
}
