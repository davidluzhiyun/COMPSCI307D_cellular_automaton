package cellsociety.alternativeModel.cell.spreadOfFireCells;

import cellsociety.alternativeModel.ImmutableNeighbourhood;
import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.StationaryCell;
import java.util.Random;

public class TreeCell extends StationaryCell {
  public static final double DEFAULT_PARAM = 0.15;
  private double myParam;
  public TreeCell(double param){
    super();
    setType(CellType.TREE);
    myParam = param;
  }
  public TreeCell(){
    this(DEFAULT_PARAM);
  }

  @Override
  public StationaryCell update(ImmutableNeighbourhood neighbourhood) {
    int burningNeighbours = countNeighbour(CellType.FIRE,neighbourhood.getVonNeumannNeighbourhood());
    double diceRoll = Math.random();
    if (diceRoll < myParam && burningNeighbours != 0){
      return new FireCell(myParam);
    }
    else{
      return new TreeCell(myParam);
    }
  }
}
