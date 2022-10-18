package cellsociety;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class GamesTest {

  @Test
  void gameOfLife() {
    List<Cell> cellList = new ArrayList<Cell>();
    List<Integer> statusList = new ArrayList<Integer>();
    for(int i = 0; i< 5; i++){
      for(int j = 0; j < 5; j++){
        Cell newCell = new Cell(i, j);
        cellList.add(newCell);
        if ((i == 2)&&(j >= 1)&&(j<=3)){
          statusList.add(1);
        }
        else {
          statusList.add(0);
        }
      }
    }
    HashMap<Cell, Integer> testMap = CellMap.CreateMap(cellList, statusList);
    Games.GameOfLife(CellMap.AllCells(testMap),testMap);
    for(int i = 0; i< 5; i++){
      for(int j = 0; j < 5; j++){
        Cell newCell = new Cell(i, j);
        if ((j == 2)&&(i >= 1)&&(i<=3)){
          assertEquals(testMap.get(newCell),1);
        }
        else {
          assertEquals(testMap.get(newCell),0);
        }
      }
    }
  }
}