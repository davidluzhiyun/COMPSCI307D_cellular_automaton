package cellsociety.parsing;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class DataFileParser {
    private File dataFile;

    public DataFileParser(File dataFile){
        this.dataFile = dataFile;
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
