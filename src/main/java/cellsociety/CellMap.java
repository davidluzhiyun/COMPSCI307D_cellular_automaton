package cellsociety;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class CellMap {

  /**
   * Still need to add how we are going to iterate over all the cells in the file that are alive,
   * although we could just create a new cell map for every coordinate and then update it for the ones
   * that are alive
   * @return
   */
  protected static HashMap<Cell, Integer> CreateMap(List<Cell> cells, List<Integer> cellStatuses){
    HashMap<Cell, Integer> CellMap = new HashMap<>();
    for(int i = 0; i < cells.size(); i++){
      CellMap.put(cells.get(i), cellStatuses.get(i));
    }
    return CellMap;
  }
  protected static Set<Entry<Cell, Integer>> AllCells(HashMap<Cell, Integer> activeMap){
    return activeMap.entrySet();
  }
}
