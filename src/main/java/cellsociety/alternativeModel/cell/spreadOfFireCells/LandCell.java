package cellsociety.alternativeModel.cell.spreadOfFireCells;

import cellsociety.alternativeModel.ImmutableNeighbourhood;
import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.StationaryCell;

public class LandCell extends StationaryCell {

  public static final double DEFAULT_PARAM = 0.15;
  private double myParam;

  public LandCell(double param){
    super();
    setType(CellType.LAND);
    myParam = param;
  }
  public LandCell(){
    this(DEFAULT_PARAM);
  }
  @Override
  public StationaryCell update(ImmutableNeighbourhood neighbourhood) {
    return new LandCell(myParam);
  }
}
