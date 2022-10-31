package cellsociety.controller;

import java.util.ArrayList;
import java.util.List;

public class GameState {
  private int gridHeight;
  private int gridWidth;
  private String simulationTitle;
  private List<List<Integer>> cellStateGrid = new ArrayList<>();
  private Controller controller;

  public GameState(int gridHeight, int gridWidth, String simulationTitle){
    gridHeight = getGridHeight();
    gridWidth = getGridWidth();
    simulationTitle = getSimulationTitle();
  }

  public String getSimulationTitle(){
    return controller.simProperties.getProperty("Type") + ": " + controller.simProperties.getProperty("Title");
  }

  public List<List<Integer>> getCellStateGrid(){
    return controller.makeInitialGridDisplayStatesFromStateList();
  }

  public int getGridHeight() {
    return controller.findGridHeight();
  }

  public int getGridWidth() {
    return controller.findGridWidth();
  }
}
