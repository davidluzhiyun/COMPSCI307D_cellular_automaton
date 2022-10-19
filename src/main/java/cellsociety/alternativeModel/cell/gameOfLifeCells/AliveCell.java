package cellsociety.alternativeModel.cell.gameOfLifeCells;

import cellsociety.alternativeModel.Coordinate;
import cellsociety.alternativeModel.cell.Cell;
import java.util.Map;

/**
 * Alive cells for game of live
 * @author david_luzhiyun
 */

public class AliveCell extends Cell {

  public AliveCell(){
    super();
    type = 1;
  }
  @Override
  public Cell update(Map<Coordinate, Integer> neighbours) {
    int livingNeighbours = countNeighbour(1,neighbours);
    if (livingNeighbours == 2){
      return new AliveCell();
    }
    else {
      return new DeadCell();
    }
  }
}
