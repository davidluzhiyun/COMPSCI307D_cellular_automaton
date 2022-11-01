package cellsociety.alternativeModel;

import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.AbstractCell;
import java.util.HashMap;
import java.util.Map;

/**
 * Data Class, used to pass information about neighbourhood around in a flexible manner
 * Package friendly because it should only be directly accessed by game model
 * Cells should access it through interface
 */
class Neighbourhood implements ImmutableNeighbourhood{
  private Map<Coordinate, CellType> mooreNeighbourhood;
  private Map<Coordinate, CellType> vonNeumannNeighbourhood;
  private Map<Coordinate, CellType> wrapAroundMooreNeighbourhood;
  private Map<Coordinate, CellType> wrapAroundVonNeumannNeighbourhood;
  private int centerX;
  private int centerY;
  public Neighbourhood(int x, int y){
    centerX = x;
    centerY = y;
    mooreNeighbourhood = new HashMap<>();
    vonNeumannNeighbourhood = new HashMap<>();
    wrapAroundMooreNeighbourhood = new HashMap<>();
    wrapAroundVonNeumannNeighbourhood = new HashMap<>();
  }

  // Auxiliary methods to prevent duplicated code
  private CellType safeGetCellType(AbstractCell myCell){
    CellType type;
    if (myCell == null){
      type = CellType.EMPTY;
    }
    else {
      type = myCell.getType();
    }
    return type;
  }

  public void putVonNeumannNeighbour(int x,int y, AbstractCell myCell){
    CellType type = safeGetCellType(myCell);
    Coordinate myCoordinate = new Coordinate(x,y);
    vonNeumannNeighbourhood.put(myCoordinate,type);
    mooreNeighbourhood.put(myCoordinate,type);
    wrapAroundVonNeumannNeighbourhood.put(myCoordinate, type);
    wrapAroundMooreNeighbourhood.put(myCoordinate, type);
  }

  public void putMooreNeighbour(int x,int y, AbstractCell myCell){
    CellType type = safeGetCellType(myCell);
    Coordinate myCoordinate = new Coordinate(x,y);
    mooreNeighbourhood.put(myCoordinate,type);
    wrapAroundMooreNeighbourhood.put(myCoordinate, type);
  }

  public void putWrapAroundVonNeumannNeighbour(int x,int y, AbstractCell myCell){
    CellType type = safeGetCellType(myCell);
    Coordinate myCoordinate = new Coordinate(x,y);
    wrapAroundVonNeumannNeighbourhood.put(myCoordinate, type);
    wrapAroundMooreNeighbourhood.put(myCoordinate, type);
  }

  public void putWrapAroundMooreNeighbour(int x,int y, AbstractCell myCell){
    CellType type = safeGetCellType(myCell);
    Coordinate myCoordinate = new Coordinate(x,y);
    wrapAroundMooreNeighbourhood.put(myCoordinate, type);
  }

  private void removeCenter(){
    Coordinate center = new Coordinate(centerX,centerY);
    mooreNeighbourhood.remove(center);
    vonNeumannNeighbourhood.remove(center);
    wrapAroundMooreNeighbourhood.remove(center);
    wrapAroundVonNeumannNeighbourhood.remove(center);
  }

  // Getters. Because the purpose of the class is to pass around neighbour information in a flexible
  // way
  // Output as map without being wrapped around because not sure at this point what the cell want
  // to do about the information
  public Map<Coordinate, CellType> getMooreNeighbourhood() {
    removeCenter();
    return new HashMap<>(mooreNeighbourhood);
  }

  public Map<Coordinate, CellType> getVonNeumannNeighbourhood() {
    removeCenter();
    return new HashMap<>(vonNeumannNeighbourhood);
  }


  public Map<Coordinate, CellType> getWrapAroundMooreNeighbourhood() {
    removeCenter();
    return new HashMap<> (wrapAroundMooreNeighbourhood);
  }

  public Map<Coordinate, CellType> getWrapAroundVonNeumannNeighbourhood() {
    removeCenter();
    return new HashMap<> (wrapAroundVonNeumannNeighbourhood);
  }
}
