package cellsociety.parsing;

import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.scene.control.Alert;

public class DataFileParser {

  private final File dataFile;
  private int rows;
  private int columns;


  public DataFileParser(File dataFile) {
    this.dataFile = dataFile;
  }

  //Code for reading the CSV file from:
// https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
// Java code to illustrate reading a file all data at once
  private Grid dataFileParser(String simulationFile) {
    //ADD GLOBAL CONSTANT FOR DATA FILE PATH
    List<String> simulationInformation = simFileParser(simulationFile);
    Properties simulationPropertiesFile = new Properties(simulationInformation.size());
    for (String simulationLine : simulationInformation) {
      int equalsIndex = simulationLine.indexOf("=");
      String key = simulationLine.substring(0, equalsIndex);
      String value = simulationLine.substring(equalsIndex + 1);
      simulationPropertiesFile.setProperty(key, value);
    }
    Grid simulationGrid = gridAssembly(simulationPropertiesFile);
    return simulationGrid;
  }

  private Grid gridAssembly(Properties simulationPropertiesFile) {
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
    List<String[]> gridValues = readAllCSVDataAtOnce(gridFile);
    //new grid
    if (gridValues.size() == 0) {

    }
    //Add map of enum values
    rows = Integer.parseInt(gridValues.get(0)[0]);
    columns = Integer.parseInt(gridValues.get(0)[1]);
    DeadCell gridDefault = new DeadCell();
    Grid cellGrid = new Grid(rows, columns, gridDefault);
    gridSetup(gridValues, cellGrid, gridType, rows, columns);
    return cellGrid;
  }

  /**
   * Implement the different systems that will use the additional parameters besides just the rows
   * and columns for the grid For now the default is simply a game of life grid The method would
   * take in the type and then go from there, possibly extending another method
   */
  private void gridSetup(List<String[]> gridValues, Grid cellGrid, String type,
      int rows, int columns) {
    for (int r = 1; r < rows + 1; r++) {
      for (int c = 0; c < columns; c++) {
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        if (newCellType == 0) {
          cellGrid.putCellAt(r - 1, c, new DeadCell());
        } else if (newCellType == 1) {
          cellGrid.putCellAt(r - 1, c, new AliveCell());
        }
      }
    }
  }

  private List<String> simFileParser(String simFile) {
    List<String> lines = new ArrayList<>();
    try (InputStream input = new FileInputStream(simFile)) {
      BufferedReader br = new BufferedReader(new InputStreamReader(input));
      String currentLine;
      while ((currentLine = br.readLine()) != null) {
        lines.add(br.readLine());
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return lines;
  }

  private List<String[]> readAllCSVDataAtOnce(String file) {
    List<String[]> allData = null;
    try {
      // Create an object of file reader
      // class with CSV file as a parameter.
      FileReader filereader = new FileReader(file);

      // create csvReader object
      CSVReader csvReader = new CSVReaderBuilder(filereader).build();
      allData = csvReader.readAll();
    } catch (Exception e) {
      e.printStackTrace();
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

  // display given message to user using the given type of Alert dialog box
  private void showMessage(Alert.AlertType type, String message) {
    new Alert(type, message).showAndWait();
  }
}
