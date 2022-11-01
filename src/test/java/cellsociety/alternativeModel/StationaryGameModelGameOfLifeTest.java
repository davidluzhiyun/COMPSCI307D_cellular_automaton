package cellsociety.alternativeModel;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.alternativeModel.cell.CellType;
import cellsociety.alternativeModel.cell.EmptyCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class StationaryGameModelGameOfLifeTest {

  public static final int BOUND = 4;
  private StationaryGameModel stationaryGameModelGood;
  private StationaryGameModel stationaryGameModelWrongCell;
  private Grid myBadGrid;
  StationaryGameModelGameOfLifeTest(){
    Grid myGoodGrid = new Grid(BOUND, BOUND, new DeadCell());
    myBadGrid = new Grid(BOUND,BOUND);
    for (int i = 1; i < BOUND; i++) {
      myGoodGrid.putCellAt(2,i,new AliveCell());
      myBadGrid.putCellAt(2,i, new AliveCell());
    }
    stationaryGameModelGood = new StationaryGameModel(myGoodGrid);
    myGoodGrid.putCellAt(0,0, new EmptyCell());
    stationaryGameModelWrongCell = new StationaryGameModel(myGoodGrid);
  }

  private void mapAssert(ImmutableTypeGrid target){
    List<Coordinate> alivePlaces = new ArrayList<>();
    for (int i = 1; i < BOUND; i++) {
      alivePlaces.add(new Coordinate(i,2));
    }
    for (int i = 0; i <= BOUND; i++) {
      for (int j = 0; j <= BOUND; j++) {
        Coordinate coordinate = new Coordinate(i,j);
        if (alivePlaces.contains(coordinate)) {
          assertEquals(CellType.ALIVE, target.getTypeTagAt(i,j));
        }
        else {
          assertEquals(CellType.DEAD, target.getTypeTagAt(i,j));
        }
      }
    }
  }
  @Test
  void constructorSad(){
    assertThrows(AssertionError.class,()->{
      StationaryGameModel model = new StationaryGameModel(myBadGrid);
    });
  }
  @Test
  void stepGood() {
    stationaryGameModelGood.step();
    mapAssert(stationaryGameModelGood.lookCurrentGrid());
  }

  @Test
  void stepBad() {
    assertThrows(AssertionError.class, () -> {
      stationaryGameModelWrongCell.step();
    });
  }
}