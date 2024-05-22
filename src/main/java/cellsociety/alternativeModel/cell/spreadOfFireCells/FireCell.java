package cellsociety.alternativeModel.cell.spreadOfFireCells;

import cellsociety.alternativeModel.ImmutableNeighbourhood;
import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.EmptyCell;
import cellsociety.alternativeModel.cell.StationaryCell;

public class FireCell extends StationaryCell {

  public static final double DEFAULT_PARAM = 0.15;
  private double myParam;

  public FireCell(double param){
    super();
    setType(CellType.FIRE);
    myParam = param;
  }
  public FireCell(){
    this(DEFAULT_PARAM);
  }

  @Override
  public StationaryCell update(ImmutableNeighbourhood neighbourhood) {
    return new LandCell(myParam);
  }
}
