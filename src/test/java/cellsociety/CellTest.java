package cellsociety;

import cellsociety.model.Cell;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class CellTest {
  private Cell cell;

  @BeforeEach
  public void setCell() {
    cell = new Cell(1);
    cell.setCellX(17);
    cell.setCellY(32);
  }

  @Test
  void testGetState() {
    int real = 1;
    assertEquals(real, cell.getState());
  }

  @Test
  void testGetAndSetX() {
    int real = 27;
    cell.setCellX(27);
    assertEquals(real, cell.getCellX());
  }

  @Test
  void testGetAndSetY() {
    int real = 14;
    cell.setCellX(14);
    assertEquals(real, cell.getCellX());
  }

  @Test
  void testGetAndSetNotEquals() {
    int real = 12;
    cell.setCellX(17);
    assertNotEquals(real, cell.getCellX());
  }

}
