package cellsociety;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Games {

  protected static void GameOfLife(Set<Entry<Cell, Integer>> modelSet, HashMap<Cell, Integer> lifeMap) {
    int neighborCount;
    for (Entry<Cell, Integer> currentEntry : modelSet) {
      neighborCount = 0;
      Cell currentCell = currentEntry.getKey();
      Integer currentStatus = currentEntry.getValue();
      for (int row = -1; row < 2; row++) {
        for (int column = -1; column < 2; column++) {
          int neighborCellX = currentCell.xCoordinate() + row;
          int neighborCellY = currentCell.yCoordinate() + column;
          Cell neighborCell = new Cell(neighborCellX, neighborCellY);
          if(lifeMap.get(neighborCell) == 1 && neighborCellX != currentCell.xCoordinate() && neighborCellY != currentCell.yCoordinate()) {
            neighborCount += 1;
          }
        }
      }
      if(neighborCount > 3 || neighborCount < 2){
        lifeMap.replace(currentCell, currentStatus, Cell.DEAD);
      }
      else if(neighborCount == 3 && currentStatus == Cell.DEAD){
        lifeMap.replace(currentCell, currentStatus, Cell.ALIVE);
      }
      }
    }
  }
