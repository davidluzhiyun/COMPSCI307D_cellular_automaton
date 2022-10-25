package cellsociety.parsing;

import cellsociety.alternativeModel.cell.Cell;
import cellsociety.alternativeModel.Grid;
import cellsociety.alternativeModel.cell.gameOfLifeCells.AliveCell;
import cellsociety.alternativeModel.cell.gameOfLifeCells.DeadCell;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.util.List;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class DataFileParser {
    private File dataFile;
    private int rows;
    private int columns;
    private double parameters;
    private String type;
    private String title;
    private String initialStates;
    private String author;
    private String description;
    private String[] stateColors;
    public static final String GAME_FILE_PATHWAY = "data/";

    public DataFileParser(File dataFile){
        this.dataFile = dataFile;
    }

//Code for reading the CSV file from:
// https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv/
// Java code to illustrate reading a file all data at once
    private Grid simulationFileParser(String simulationFile){
        parameters = 0;
        List<String[]> simulationInformation = readAllDataAtOnce(simulationFile);
        for(String[] simulationLine : simulationInformation){
            int equalsIndex = simulationLine[0].indexOf("=");
            String neededInformation = simulationLine[0].substring(equalsIndex);
            if(simulationLine[0].contains("Type")){
                type = neededInformation;
            } else if (simulationLine[0].contains("Title")) {
                title = neededInformation;
            } else if (simulationLine[0].contains("Author")) {
                author = neededInformation;
            } else if (simulationLine[0].contains("Description")) {
                description = neededInformation;
            } else if (simulationLine[0].contains("InitialStates")) {
                initialStates = neededInformation;
            } else if (simulationLine[0].contains("Parameters")) {
                parameters = Double.parseDouble(neededInformation);
            } else if (simulationLine[0].contains("StateColors")) {
                stateColors = neededInformation.split(",");
            }
        }
        Grid simulationGrid = csvParser(initialStates, type, parameters, stateColors);
        return simulationGrid;
    }
    private Grid csvParser(String gameOfLifeFile, String type, double parameters, String[] stateColors){
        List<String[]> gridValues = readAllDataAtOnce(gameOfLifeFile);
        //new grid
        if(gridValues == null){
            //Add exception for null
        }
        //Add map of enum values
        rows = Integer.parseInt(gridValues.get(0)[0]);
        columns = Integer.parseInt(gridValues.get(0)[1]);
        DeadCell gridDefault = new DeadCell();
        Grid cellGrid = new Grid(rows, columns, gridDefault);
        switch(type.toUpperCase()){
            case ("GAMEOFLIFE") -> {
                gameOfLifeSetup(gridValues, cellGrid, rows, columns);
            }
            case ("FIRE") -> {
                fireSetup(gridValues, cellGrid, rows, columns);
            }
            case ("PERCOLATION") -> {
                percolationSetup(gridValues, cellGrid, rows, columns);
            }
            case ("ROCKPAPERSCISSOR") -> {
                rockPaperScissorsSetup(gridValues, cellGrid, rows, columns);
            }
            case ("SEGREGATION") -> {
                segregationSetup(gridValues, cellGrid, rows, columns);
            }
            case ("WATORWORLD") -> {
                watorWorldSetup(gridValues, cellGrid, rows, columns);
            }
        }
        return cellGrid;
    }





    private static void gameOfLifeSetup(List<String[]> gridValues, Grid cellGrid, int rows, int columns){
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
    }

    private static List<String[]> readAllDataAtOnce(String file) {
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
    public int sumCSVData (Reader dataReader) {
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
        }
        catch (IOException | CsvValidationException e) {
            showMessage(Alert.AlertType.ERROR, "Invalid CSV Data");
            return 0;
        }
    }

    // display given message to user using the given type of Alert dialog box
    private void showMessage (Alert.AlertType type, String message) {
        new Alert(type, message).showAndWait();
    }
}
