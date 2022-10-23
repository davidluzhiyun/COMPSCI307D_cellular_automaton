package cellsociety.alternativeModel.cell.gameOfLifeCells;

import cellsociety.alternativeModel.Coordinate;
import cellsociety.alternativeModel.cell.Cell;
import cellsociety.alternativeModel.cell.CellType;
import java.util.Map;

/**
 * Alive cells for game of live
 * @author david_luzhiyun
 */

public class AliveCell extends Cell {

  public AliveCell(){
    super();
    type = CellType.ALIVE;
  }
  @Override
  public Cell update(Map<Coordinate, CellType> neighbours) {
    int livingNeighbours = countNeighbour(CellType.ALIVE,neighbours);
    if (livingNeighbours == 2){
      return new AliveCell();
    }
    else {
      return new DeadCell();
    }
  }
}
