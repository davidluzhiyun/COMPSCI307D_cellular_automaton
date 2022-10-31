package cellsociety.controller;

import java.util.ArrayList;
import java.util.List;

public class GameState {
  private int gridHeight;
  private int gridWidth;
  private String simulationTitle;
  private List<List<Integer>> cellStateGrid = new ArrayList<>();

  public GameState(int gridHeight, int gridWidth, String simulationTitle){

  }

  public String getSimulationTitle(){
    return simulationTitle;
  }

  public List<List<Integer>> getCellStateGrid(){
    return cellStateGrid;
  }

  public int getGridHeight() {
    return gridHeight;
  }

  public int getGridWidth() {
    return gridWidth;
  }
}
