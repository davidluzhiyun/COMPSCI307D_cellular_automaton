package cellsociety.controller;

import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class CSVInitialGridParser {

  private String simulationType;

  private File dataFile;
  private int rows;
  private int columns;


  public static List<String[]> readAllDataAtOnce(String file) {
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

  private Grid initialStateParser(String stateFile, String simulationType){
    List<String[]> gridValues = readAllDataAtOnce(stateFile);
    //new grid
    if(gridValues == null){

    }

    //Add map of enum values
    rows = Integer.parseInt(gridValues.get(0)[0]);
    columns = Integer.parseInt(gridValues.get(0)[1]);
    DeadCell gridDefault = new DeadCell();
    Grid cellGrid = new Grid(rows, columns, gridDefault);
    for(int r = 1; r < rows + 1; r++){
      for(int c = 0; c < columns; c++){
        int newCellType = Integer.parseInt(gridValues.get(r)[c]);
        if(newCellType == 0){
          cellGrid.putCellAt(r-1, c, new DeadCell());
        }
        else if(newCellType == 1){
          cellGrid.putCellAt(r-1, c, new AliveCell());
        }
      }
    }
    return cellGrid;
  }

}
