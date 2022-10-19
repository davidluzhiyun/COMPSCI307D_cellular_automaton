package cellsociety.alternativeModel.cell.gameOfLifeCells;

import cellsociety.alternativeModel.Coordinate;
import cellsociety.alternativeModel.cell.Cell;
import java.util.Map;

public class DeadCell extends Cell {
  public DeadCell(){
    super();
    type = 0;
  }

  @Override
  public Cell update(Map<Coordinate, Integer> neighbours) {
    int livingNeighbours = countNeighbour(1,neighbours);
    if (livingNeighbours == 3){
      return new AliveCell();
    }
    else {
      return new DeadCell();
    }
  }
}
