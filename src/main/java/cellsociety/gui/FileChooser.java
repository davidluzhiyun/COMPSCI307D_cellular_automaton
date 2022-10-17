package cellsociety.gui;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * This class generates an interactive file explorer for the user to select a data file.
 */
public class FileChooser {
    private static FileChooser instance = null;

    public static final String DATA_FILE_CSV_EXTENSION = "*.csv";
    // default to start in the data folder to make it easy on the user to find
    public static final String DATA_FILE_FOLDER = System.getProperty("user.dir") + "/data";
    // NOTE: make ONE chooser since generally accepted behavior is that it remembers where user left it last
    private final static javafx.stage.FileChooser FILE_CHOOSER = makeChooser(DATA_FILE_CSV_EXTENSION);
    // internal configuration file

    private File dataFile;
    private FileChooser(){
        //TODO: Implement as singleton? We should only have one instance at a time.
    }

    public static FileChooser getInstance(){
        if(instance == null){
            instance = new FileChooser();
        }
        return instance;
    }

    /**
     * Creates a pop-up file explorer for the user to select their desired data file.
     */
    public void promptFileChooser(){
        this.dataFile = FILE_CHOOSER.showOpenDialog(new Stage());
//
//        try {
//            this.dataFile = FILE_CHOOSER.showOpenDialog(new Stage());
//            if (dataFile != null) {
//                int sum = sumCSVData(new FileReader(dataFile));
//                showMessage(AlertType.INFORMATION, "" + sum);
//            }
//        }
//        catch (IOException e) {
//            // should never happen since user selected the file
//            showMessage(AlertType.ERROR, "Invalid Data File Given");
//        }
    }

    /**
     * @return the data file the user selected.
     */
    public File getDataFile(){
        if(this.dataFile == null){
            throw new RuntimeException("Data file not selected!");
        }
        return this.dataFile;
    }

    // set some sensible defaults when the FileChooser is created
    private static javafx.stage.FileChooser makeChooser (String extensionAccepted) {
        javafx.stage.FileChooser result = new javafx.stage.FileChooser();
        result.setTitle("Open Data File");
        // pick a reasonable place to start searching for files
        result.setInitialDirectory(new File(DATA_FILE_FOLDER));
        result.getExtensionFilters().setAll(new javafx.stage.FileChooser.ExtensionFilter("CSV Files", extensionAccepted));
        return result;
    }
}
