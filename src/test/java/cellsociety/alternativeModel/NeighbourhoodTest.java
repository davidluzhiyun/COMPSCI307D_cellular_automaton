package cellsociety.alternativeModel;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import java.util.Map;
import org.junit.jupiter.api.Test;

class NeighbourhoodTest {
  private Neighbourhood my;
  private Map<Coordinate,CellType> myVonNeumannNeighbourhood;
  private Map<Coordinate,CellType> myMooreNeighbourhood;
  private Map<Coordinate,CellType> myWrapAroundVonNeumannNeighbourhood;
  private Map<Coordinate,CellType> myWrapAroundMooreNeighbourhood;
  NeighbourhoodTest(){
    my = new Neighbourhood(0,0);
    my.putVonNeumannNeighbour(0,1,new AliveCell());
    my.putMooreNeighbour(0,2,new AliveCell());
    my.putWrapAroundVonNeumannNeighbour(0,3,new AliveCell());
    my.putWrapAroundMooreNeighbour(0,4,new AliveCell());

    //Bad paths
    my.putVonNeumannNeighbour(0,0,new AliveCell());
    my.putVonNeumannNeighbour(0,5,null);
    // Getting
    myVonNeumannNeighbourhood = my.getVonNeumannNeighbourhood();
    myMooreNeighbourhood = my.getMooreNeighbourhood();
    myWrapAroundVonNeumannNeighbourhood = my.getWrapAroundVonNeumannNeighbourhood();
    myWrapAroundMooreNeighbourhood = my.getWrapAroundMooreNeighbourhood();
  }
  @Test
  void putVonNeumannNeighbour() {
    Coordinate myCoordinate = new Coordinate(0,1);
    assertEquals(CellType.ALIVE,myVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myMooreNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myWrapAroundVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myWrapAroundMooreNeighbourhood.get(myCoordinate));
  }

  @Test
  void putMooreNeighbour() {
    Coordinate myCoordinate = new Coordinate(0,2);
    assertEquals(null,myVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myMooreNeighbourhood.get(myCoordinate));
    assertEquals(null,myWrapAroundVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myWrapAroundMooreNeighbourhood.get(myCoordinate));
  }

  @Test
  void putWrapAroundVonNeumannNeighbour() {
    Coordinate myCoordinate = new Coordinate(0,3);
    assertEquals(null,myVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(null,myMooreNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myWrapAroundVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myWrapAroundMooreNeighbourhood.get(myCoordinate));
  }

  @Test
  void putWrapAroundMooreNeighbour() {
    Coordinate myCoordinate = new Coordinate(0,4);
    assertEquals(null,myVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(null,myMooreNeighbourhood.get(myCoordinate));
    assertEquals(null,myWrapAroundVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.ALIVE,myWrapAroundMooreNeighbourhood.get(myCoordinate));
  }

  @Test
  void centerRemoval() {
    Coordinate myCoordinate = new Coordinate(0,0);
    assertEquals(null,myVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(null,myMooreNeighbourhood.get(myCoordinate));
    assertEquals(null,myWrapAroundVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(null,myWrapAroundMooreNeighbourhood.get(myCoordinate));
  }

  void nullHandle() {
    Coordinate myCoordinate = new Coordinate(0,5);
    assertEquals(CellType.EMPTY,myVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.EMPTY,myMooreNeighbourhood.get(myCoordinate));
    assertEquals(CellType.EMPTY,myWrapAroundVonNeumannNeighbourhood.get(myCoordinate));
    assertEquals(CellType.EMPTY,myWrapAroundMooreNeighbourhood.get(myCoordinate));
  }
}