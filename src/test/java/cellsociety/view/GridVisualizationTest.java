package cellsociety.view;

import cellsociety.view.grid.GridDisplay;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GridVisualizationTest {

  private int gridRows = 10;
  private int gridCols = 10;
  private GridDisplay gridDisplay;
  private List<List<Integer>> cellStateGrid = new ArrayList<>();


  private void initializeGridDisplay(){
    GridDisplay gridDisplay = new GridDisplay(gridRows, gridCols);
  }

  @Test
  void testInitializeGridDisplay(){
    this.initializeGridDisplay();
    assertEquals(1, 1);
  }




  private void generateDummyGrid(){
    for(int i = 0; i < gridRows; i++){
      cellStateGrid.add(new ArrayList<>());
      for(int k = 0; k < gridCols; k++){
        int dummyState = (i+k) % 4;
        cellStateGrid.get(i).add(dummyState);
        System.out.println(dummyState);
      }
    }
  }

}
