package cellsociety.model;

import cellsociety.model.Cell;
import java.util.HashMap;

public class CellMapCreator {

  enum Status{
    DEAD(0),
    ALIVE(1);
    private int statusValue;
    Status(int value){
      this.statusValue = value;
    }
    private int getStatus() {
      return this.statusValue;
    }
  }

  /**
   * Still need to add how we are going to iterate over all the cells in the file that are alive,
   * although we could just create a new cell map for every coordinate and then update it for the ones
   * that are alive
   * @param rows
   * @param columns
   * @param status
   * @return
   */
  public static HashMap<Cell, Integer> CreateMap(int rows, int columns, int status){

    HashMap<Cell, Integer> CellMap = new HashMap<>();
    return CellMap;
  }

}
