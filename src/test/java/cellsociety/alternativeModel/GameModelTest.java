package cellsociety.alternativeModel;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.alternativeModel.cell.Cell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GameModelTest {

  public static final int Bound = 4;
  private GameModel withNullGood;
  private GameModel withNullBad;
  public GameModelTest(){
    Map<Coordinate, Cell> mapWithNull = new HashMap<>();
    for (int i = 1; i < Bound; i++) {
      mapWithNull.put(new Coordinate(2,i), new AliveCell());
    }
    withNullGood = new GameModel(mapWithNull, Bound, Bound, new DeadCell());
    withNullBad = new GameModel(mapWithNull, Bound, Bound);

  }

  private void mapAssert(Map<Coordinate, Cell> target){
    List<Coordinate> alivePlaces = new ArrayList<>();
    for (int i = 1; i < Bound; i++) {
      alivePlaces.add(new Coordinate(i,2));
    }
    for (int i = 0; i <= Bound; i++) {
      for (int j = 0; j <= Bound; j++) {
        Coordinate coordinate = new Coordinate(i,j);
        if (alivePlaces.contains(coordinate)) {
          assertEquals(1, target.get(coordinate).getType());
        }
        else {
          assertEquals(0, target.get(coordinate).getType());
        }
      }
    }
  }
  @Test
  void stepGood() {
    withNullGood.step();
    Map<Coordinate, Cell> updated= withNullGood.lookCurrentGrid();
    mapAssert(updated);
    GameModel withoutNull = new GameModel(updated, Bound, Bound);
    withoutNull.step();
    withoutNull.step();
    //mapAssert(withoutNull.lookCurrentGrid());
  }

  @Test
  void stepBad() {
    assertThrows(NullPointerException.class, () -> {
      withNullBad.step();
    });
  }
}