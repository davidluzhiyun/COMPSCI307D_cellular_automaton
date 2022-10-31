package cellsociety.controller;

import java.util.ArrayList;
import java.util.List;

public class GameState {
  private int gridHeight;
  private int gridWidth;
  private String simulationTitle;
  private String gameType;
  private String gameAuthor;
  private String gameDescription;

  private List<List<Integer>> cellStateGrid = new ArrayList<>();
  private Controller controller;

  public GameState(Controller controller){
    this.controller = controller;
    this.gridHeight = getGridHeight();
    this.gridWidth = getGridWidth();
    this.simulationTitle = getSimulationTitle();
  }

  public List<List<Integer>> getCellStateGrid() {
    return cellStateGrid;
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

  public String getGameAuthor() {
    return (String) controller.simProperties.get("Author");
  }

  public String getGameDescription() {
    return (String) controller.simProperties.get("Description");
  }

  public String getGameType() {
    return (String) controller.simProperties.get("Type");
  }
}
