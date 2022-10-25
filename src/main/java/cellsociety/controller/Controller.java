package cellsociety.controller;

import cellsociety.gui.GUI;
import cellsociety.gui.GUIPropertiesLoader;
import cellsociety.gui.SimInformationDisplay;

public class Controller {

  private GUI simGUI;
  private GUIPropertiesLoader GUIprops;
  private SimInformationDisplay simInfo;


  /**
   * Constructor for Frontend Action Controller, needs
   * to be able to make the view based on the game, and therefore have instances
   * of necessary GUI classes
   */
  public Controller(GUI gui) {
    simGUI = gui;
  }

  /**
   * Setup the game chosen in the splash screen by the user
   */
  public void setupGameChosen(String s) {

  }

  /**
   * Set the language choice chosen by the user
   */
  public void setLanguageChoice() {

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

}
