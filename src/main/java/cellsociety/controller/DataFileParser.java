package cellsociety.controller;

import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.scene.control.Alert;

public class DataFileParser {

  public DataFileParser(File dataFile) {
  }

  /**
   * The method parseSimFile is used to take the information from the sim files and then package it
   * in the form of a properties file. This allows for the information to be neatly passed around
   * not only the DataFileParser class, but to other classes and methods outside.
   */

  public static Properties parseSimFile(String simulationFile) {
    List<String> simulationInformation = simFileParser(simulationFile);
    Properties simulationPropertiesFile = new Properties(simulationInformation.size());
    for (String simulationLine : simulationInformation) {
      int equalsIndex = simulationLine.indexOf("=");
      if (equalsIndex == -1) {
        continue;
      }
      String key = simulationLine.substring(0, equalsIndex);
      String value = simulationLine.substring(equalsIndex + 1);
      simulationPropertiesFile.setProperty(key, value);
    }
    return simulationPropertiesFile;
  }

  /**
   * The method simFileParser is used the get all the information from the sim file separated by
   * line.
   */
  private static List<String> simFileParser(String simFile) {
    List<String> lines = new ArrayList<>();
    try (InputStream input = new FileInputStream(simFile)) {
      BufferedReader br = new BufferedReader(new InputStreamReader(input));
      String currentLine = br.readLine();
      while ((currentLine != null)) {
        lines.add(currentLine);
        currentLine = br.readLine();
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return lines;
  }

  /**
   * The method gridAssembly is responsible for extracting all the necessary information from the
   * properties file created from the sim file. These values are then put into the gridSetup method
   * to then set the proper cells in the grid from the initial states.
   */
  public Grid gridAssembly(Properties simulationPropertiesFile)
      throws InvocationTargetException, IllegalAccessException {
    try {
      simulationPropertiesFile.getProperty("InitialStates");
    } catch (Exception noInitialStates) {
      System.out.println(
          "No CSV file for cell states detected, enter desired CSV file name or reselect sim file.");
    }
    try {
      simulationPropertiesFile.getProperty("Type");
    } catch (Exception noFileType) {
      System.out.println("No game type found, enter desired game type or reselect sim file.");
    }
    String gridFile = simulationPropertiesFile.getProperty("InitialStates");
    String gridType = simulationPropertiesFile.getProperty("Type");
    Double gridParameter = 0.0;
    if (simulationPropertiesFile.containsKey("Parameter")) {
      gridParameter = Double.parseDouble(simulationPropertiesFile.getProperty("Parameter"));
    }
    List<String[]> gridValues = readAllCSVDataAtOnce(gridFile);
    if (gridValues.size() == 0) {
      System.out.println("No initial state values found within the CSV file.");
    }
    int rows = Integer.parseInt(gridValues.get(0)[1]);
    int columns = Integer.parseInt(gridValues.get(0)[0]);
    DeadCell gridDefault = new DeadCell();
    Grid cellGrid = new Grid(rows, columns, gridDefault);
    gridSetup(gridValues, cellGrid, gridType, gridParameter, rows, columns);
    return cellGrid;
  }

  /**
   * The method below is responsible for taking in the information from the sim file and the CSV
   * file to set up the grid for the model. Specifically, making sure that the grid set up method
   * from the TypeSetup class matches that of the type given in the sim file to be able to
   * accurately determine what the values present in the CSV file mean in terms of what kinds of
   * cells should be placed inside the grid.
   */
  private void gridSetup(List<String[]> gridValues, Grid cellGrid, String type,
      Double gridParameter, int rows, int columns)
      throws InvocationTargetException, IllegalAccessException {
    TypeSetup gridReflection = new TypeSetup();
    Method typeMethod = null;
    try {
      typeMethod = TypeSetup.class.getDeclaredMethod(type.toLowerCase());
    } catch (NoSuchMethodException e) {
      System.out.println("Invalid game type, select desired game type.");
    }
    typeMethod.setAccessible(true);
    typeMethod.invoke(gridReflection, gridValues, cellGrid, gridParameter, rows, columns);
  }

  /**
   * The method below reads all the CSV data from the given string that corresponds to the file
   * path. The string arrays are the rows, while the indices within the arrays are the column
   * locations. Code for reading the CSV file from:
   * https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/ Section: Java code to
   * illustrate reading a file all data at once
   */
  public List<String[]> readAllCSVDataAtOnce(String file) {
    List<String[]> allData = null;
    try {
      // Create an object of file reader
      // class with CSV file as a parameter.
      FileReader filereader = new FileReader(file);

      // create csvReader object
      CSVReader csvReader = new CSVReaderBuilder(filereader).build();
      allData = csvReader.readAll();
    } catch (Exception e) {
      System.out.println(
          "Invalid CSV file, please double check the sim file or select CSV file manually.");
    }
    return allData;
  }

  // NOTE: the following methods were provided by the professor for us to use
  // and perform simple tests. I would follow suit with his exception handling methods...

  /**
   * Returns sum of values in the given CSV data source (could be anything that is readable).
   */
  public int sumCSVData(Reader dataReader) {
    // this syntax automatically close file resources if an exception occurs
    try (CSVReader csvReader = new CSVReader(dataReader)) {
      int total = 0;
      // get headers separately
      String[] headers = csvReader.readNext();
      // read rest of data line by line
      String[] nextRecord;
      while ((nextRecord = csvReader.readNext()) != null) {
        for (String value : nextRecord) {
          total += Integer.parseInt(value);
        }
      }
      return total;
    } catch (IOException | CsvValidationException e) {
      showMessage(Alert.AlertType.ERROR, "Invalid CSV Data");
      return 0;
    }
  }

  // Display given message to user using the given type of Alert dialog box
  private void showMessage(Alert.AlertType type, String message) {
    new Alert(type, message).showAndWait();
  }
}
