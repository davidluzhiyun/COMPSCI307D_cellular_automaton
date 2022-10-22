package cellsociety.alternativeModel;

import static org.junit.jupiter.api.Assertions.*;

import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import org.junit.jupiter.api.Test;

/**
 * @author david_luzhiyun
 */
class GridTest {
  private Grid myGrid;

  public GridTest(){
    myGrid = new Grid(4,5, new DeadCell());
  }
  @Test
  void constructorTestSad(){
    Grid bad = new Grid(-1,-1);
    assertEquals(0,bad.getMaxX());
    assertEquals(0,bad.getMaxY());
  }
  @Test
  void constructorTestGood(){
    assertEquals(4,myGrid.getMaxX());
    assertEquals(5,myGrid.getMaxY());
  }

  @Test
  void operationsGood() {
    myGrid.putCellAt(1,2,new AliveCell());
    assertInstanceOf(AliveCell.class,myGrid.getCellAt(1,2));
    assertEquals(1,myGrid.getTypeTagAt(1,2));
  }

  @Test
  void operationsNullHandle(){
    assertInstanceOf(DeadCell.class,myGrid.getCellAt(4,5));
    assertEquals(0,myGrid.getTypeTagAt(4,5));
  }

  @Test
  void operationsBad(){
    myGrid.putCellAt(5,6, new DeadCell());
    assertThrows(AssertionError.class,()->{
      myGrid.getCellAt(5,6);
    });
    assertThrows(AssertionError.class,()->{
      myGrid.getTypeTagAt(5,6);
    });
  }

}