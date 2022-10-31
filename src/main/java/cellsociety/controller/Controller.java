package cellsociety.controller;

import cellsociety.alternativeModel.AbstractGameModel;
import cellsociety.alternativeModel.Grid;
import cellsociety.view.FileChooser;
import cellsociety.view.GUI;
import cellsociety.view.SimInformationDisplay;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

  private Stage gameStage;
  public List<String[]> initialStateList;
  public List<List<Integer>> initialCellStateGrid = new ArrayList<>();
  public Properties simProperties;
  private GameState gameState;
  private SimInformationDisplay simInfoDisplay;
  private AbstractGameModel simGameModel;
  private GUI simGUI;
  private SimInfoParser simGameInfoParser;
  private CSVInitialGridParser simStateParser;
  private Grid initialGrid;
  private DataFileParser dataFileParser;
  private ErrorChecker errorChecker;
  private ResourceBundle errorMessages;
  private static final String DEFAULT_RESOURCE_PACKAGE = "cellsociety.ControllerResources.Errors";
  private File simFile;

  private int gridWidth;
  private int gridHeight;

  /**
   * Constructor for Controller, needs
   * to be able to perform all necessary actions, and therefore have the model
   * and the view here to perform actions from
   */
  public Controller() {
    simGameInfoParser = new SimInfoParser();
    dataFileParser = new DataFileParser(FileChooser.getInstance().getDataFile());
    simFile = FileChooser.getInstance().getDataFile();
    initialStateList = new ArrayList<>();
    simProperties = new Properties();
    setUpAllGameProperties();
    gameState = new GameState(this);
    simInfoDisplay = new SimInformationDisplay((String) simProperties.get("Type"),
        (String) simProperties.get("Title"), (String) simProperties.get("Author"),
        (String) simProperties.get("Description"));
    simGUI = new GUI(gameState);
    errorChecker = new ErrorChecker();
    errorMessages = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
  }

  public Scene startGUI(){
    gameState.setCellStateGrid(makeInitialGridDisplayStatesFromStateList());
    return this.simGUI.setupScene();
  }

  public GUI getSimGUI(){
    return simGUI;
  }

  /**
   * Set up properties file with all information
   */
  public void setUpAllGameProperties() {
     simProperties = dataFileParser.parseSimFile(simFile.getAbsolutePath());
     initialStateList = dataFileParser.readAllCSVDataAtOnce("data/" + simProperties.getProperty("InitialStates"));
     gridHeight = Integer.parseInt(initialStateList.get(0)[1]);
     gridWidth = Integer.parseInt(initialStateList.get(0)[0]);
  }

  /**
   *
   * @return the height of the grid to be used on the frontend
   */
  public int findGridHeight() {
    return Integer.parseInt(initialStateList.get(0)[1]);
  }

  /**
   *
   * @return the width of the grid to be used on the frontend
   */
  public int findGridWidth() {
    return Integer.parseInt(initialStateList.get(0)[0]);
  }

  /**
   *
   * @return List of Lists of integers representing the state grid to be used in frontend
   */
  public List<List<Integer>> makeInitialGridDisplayStatesFromStateList() {
    for (int i=1; i < initialStateList.size(); i++) {
      List<Integer> tempList = new ArrayList<>();
      for (int j = 0; j < initialStateList.get(i).length; j++){
        tempList.add(Integer.parseInt(initialStateList.get(i)[j]));
      }
      initialCellStateGrid.add(tempList);
    }

    return initialCellStateGrid;
  }

  /**
   * Communicate a changed state from the backend in the model to the frontend grid
   */
}
