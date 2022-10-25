package cellsociety.controller;

import cellsociety.alternativeModel.AbstractGameModel;
import cellsociety.alternativeModel.Grid;
import java.util.Properties;
import java.util.ResourceBundle;

public class Controller {

  private Properties simProperties;
  private AbstractGameModel simGameModel;
  private SimInfoParser simGameInfoParser;
  private CSVInitialGridParser simStateParser;
  private Grid initialGrid;
  private ErrorChecker errorChecker;
  private ResourceBundle errorMessages;
  private static final String DEFAULT_RESOURCE_PACKAGE = "cellsociety.ControllerResources.Errors";

  /**
   * Constructor for Controller, needs
   * to be able to perform all necessary actions, and therefore have the model
   * and the view here to perform actions from
   */
  public Controller() {
    simGameInfoParser = new SimInfoParser();
    simProperties = new Properties();

    errorChecker = new ErrorChecker();
    errorMessages = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
  }

  /**
   * Setup the game chosen in the splash screen by the user
   */
  public void setupGameChosen(String cellularAutomataType) {
    simProperties.setProperty("Type", cellularAutomataType);
  }

  /**
   * Set the language choice chosen by the user
   */
  public void setLanguageChoice(String languageChoice) {

  }

  /**
   * Set the UI styling chosen properly
   */
  public void setUserInterfaceStyling() {

  }

  /**
   * Communicate a changed state from the backend in the model to the frontend grid
   */
  public void sendUpdatesToUI() {

  }

  /**
   * Communiate
   */

  public void startGUIfromSplash() {

  }

}
