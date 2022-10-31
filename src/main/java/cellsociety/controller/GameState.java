package cellsociety.controller;

import java.util.ArrayList;
import java.util.List;

public class GameState {
  private int gridHeight;
  private int gridWidth;
  private String simulationTitle;
  private List<List<Integer>> cellStateGrid = new ArrayList<>();
  private Controller controller;

  public GameState(Controller controller){
    this.controller = controller;
    this.gridHeight = getGridHeight();
    this.gridWidth = getGridWidth();
    this.simulationTitle = getSimulationTitle();
  }

  public String getSimulationTitle(){
    return controller.simProperties.get("Type") + ": " + controller.simProperties.get("Title");
  }

  public void setCellStateGrid(List<List<Integer>> stateGrid) {
    this.cellStateGrid = stateGrid;
  }

  public int getGridHeight() {
    return controller.findGridHeight();
  }

  public int getGridWidth() {
    return controller.findGridWidth();
  }
}
