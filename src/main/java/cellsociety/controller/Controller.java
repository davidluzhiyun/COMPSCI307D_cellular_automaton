package cellsociety.controller;

import cellsociety.alternativeModel.AbstractGameModel;
import cellsociety.alternativeModel.Grid;
import cellsociety.view.FileChooser;
import cellsociety.view.GUI;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.stage.Stage;

public class Controller {

  private Stage gameStage;
  public List<String[]> initialStateList;
  public List<List<Integer>> initialCellStateGrid = new ArrayList<>();
  private Properties simProperties;
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
    simProperties = new Properties();
    simGUI = new GUI();
    errorChecker = new ErrorChecker();
    errorMessages = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
  }

  /**
   * Set up properties file with all information
   */
  public void setUpAllGameProperties() {
     simProperties = dataFileParser.parseSimFile(String.valueOf(simFile));
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
      for (int j=0; i < initialStateList.get(i).length; j++)
        initialCellStateGrid.get(i - 1).set(j, Integer.parseInt(initialStateList.get(i)[j]));
    }
    return initialCellStateGrid;
  }

  /**
   * Communicate a changed state from the backend in the model to the frontend grid
   */
  public
}
