package cellsociety.alternativeModel.cell.gameOfLifeCells;

import cellsociety.alternativeModel.Coordinate;
import cellsociety.alternativeModel.cell.AbstractCell;
import cellsociety.alternativeModel.cell.StationaryCell;
import cellsociety.alternativeModel.cell.CellType;
import java.util.Map;

public class DeadCell extends StationaryCell {
  public DeadCell(){
    super();
    type = CellType.DEAD;
  }

  @Override
  public StationaryCell update(Map<Coordinate, CellType> neighbours) {
    int livingNeighbours = countNeighbour(CellType.ALIVE,neighbours);
    if (livingNeighbours == 3){
      return new AliveCell();
    }
    else {
      return new DeadCell();
    }
  }
}
