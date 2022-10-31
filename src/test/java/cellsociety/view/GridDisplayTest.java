package cellsociety.view;

import cellsociety.view.grid.GridDisplay;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Basic tests to check on the grid's behavior with regards to cell states.
 *
 * @author dm396
 */
public class GridDisplayTest {

  private GridDisplay gridDisplay;
  private int gridRows = 10;
  private int gridCols = 10;
  private List<List<Integer>> cellStates;


  /**
   * Ensures that the initial cell states are initialized to zero.
   */
  @Test
  public void testInitialGridState(){
    gridDisplay = new GridDisplay(gridRows, gridCols);
    cellStates = gridDisplay.getCellStates();

    for(int i = 0; i < gridRows; i++){
      for(int j = 0; j < gridCols; j++){
        assertEquals(cellStates.get(i).get(j), 0);
      }
    }
  }

  /**
   * Tests to make sure that the grid display is actually updating the
   * state of each cell by passing in a 2d list of random numbers.
   */
  @Test
  public void testUpdatedGridState(){
    gridDisplay = new GridDisplay(gridRows, gridCols);
    cellStates = generateRandomCellState();           // instance variable is filled with random numbers.
    gridDisplay.updateGridVisualization(cellStates);  // updates the values in the grid visualization

    for(int i = 0; i < gridRows; i++){
      for(int j = 0; j < gridCols; j++){
        assertEquals(gridDisplay.getCellStates().get(i).get(j), // checks to see if new grid matches its update
                    cellStates.get(i).get(j));
      }
    }
  }


  /**
   * Fills the cell state array with new random numbers.
   */
  private List<List<Integer>>  generateRandomCellState(){
    Random random = new Random();
    List<List<Integer>> randomList = new ArrayList<>();
    for(int i = 0; i < gridRows; i++){
      randomList.add(new ArrayList<>());
      for(int j = 0; j < gridCols; j++){
        int randomInt = random.nextInt(0, 5);
        randomList.get(i).add(randomInt);
      }
    }

    return randomList;
  }
}
