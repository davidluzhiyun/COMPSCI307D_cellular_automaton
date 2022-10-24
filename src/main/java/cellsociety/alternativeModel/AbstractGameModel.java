package cellsociety.alternativeModel;

import cellsociety.alternativeModel.cell.AbstractCell;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract Game Model, initialize with a grid, and output a grid. Has
 * two methods. One for updating one for outputting result.
 * @author david_luzhiyun
 */

public abstract class AbstractGameModel {
  //class variables
  protected Map<Coordinate, AbstractCell> grid;


  // size of the grid
  // represents the largest index, reachable
  protected int maxX;
  protected int maxY;

  public AbstractGameModel(Grid inputGrid) throws NullPointerException{
    try {
      maxX = inputGrid.getMaxX();
      maxY = inputGrid.getMaxY();
      grid = new HashMap<>();
      for (int i = 0; i <= inputGrid.getMaxX(); i++) {
        for (int j = 0; j <= inputGrid.getMaxY(); j++) {
          grid.put(new Coordinate(i,j), inputGrid.getCellAt(i,j));
        }
      }
    }
    catch (NullPointerException e){
      System.out.println("Input Grid can't be null");
      throw e;
    }
  }

  public abstract void step();

  public Grid lookCurrentGrid(){
    Grid output = new Grid(maxX,maxY);
    for (int i = 0; i <= maxX; i++) {
      for (int j = 0; j <= maxY; j++) {
        output.putCellAt(i,j,grid.get(new Coordinate(i,j)));
      }
    }
    return output;
  }
}
