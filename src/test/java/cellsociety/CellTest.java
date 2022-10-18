package cellsociety;

import cellsociety.model.CellConstructor;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class CellTest {
  private CellConstructor cellConstructor;

  @BeforeEach
  public void setCell() {
    cellConstructor = new CellConstructor(1);
    cellConstructor.setCellX(17);
    cellConstructor.setCellY(32);
  }

  @Test
  void testGetState() {
    int real = 1;
    assertEquals(real, cellConstructor.getState());
  }

  @Test
  void testGetAndSetX() {
    int real = 27;
    cellConstructor.setCellX(27);
    assertEquals(real, cellConstructor.getCellX());
  }

  @Test
  void testGetAndSetY() {
    int real = 14;
    cellConstructor.setCellX(14);
    assertEquals(real, cellConstructor.getCellX());
  }

  @Test
  void testGetAndSetNotEquals() {
    int real = 12;
    cellConstructor.setCellX(17);
    assertNotEquals(real, cellConstructor.getCellX());
  }

}
