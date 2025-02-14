package cellsociety.view;

import javafx.stage.Stage;

import java.io.File;

/**
 * This class generates an interactive file explorer for the user to select a data file.
 *
 * @author dm396
 */
public class FileChooser {

  private static FileChooser instance = null;

  public static final String DATA_FILE_SIM_EXTENSION = "*.sim";
  // default to start in the data folder to make it easy on the user to find
  public static final String DATA_FILE_FOLDER = System.getProperty("user.dir") + "/data";
  // NOTE: make ONE chooser since generally accepted behavior is that it remembers where user left it last
  private final static javafx.stage.FileChooser FILE_CHOOSER = makeChooser(DATA_FILE_SIM_EXTENSION);
  // internal configuration file

  private File dataFile;

  private FileChooser() {
  }

  public static FileChooser getInstance() {
    if (instance == null) {
      instance = new FileChooser();
    }
    return instance;
  }

  /**
   * Creates a pop-up file explorer for the user to select their desired data file.
   */
  public void promptFileChooser() {
    this.dataFile = FILE_CHOOSER.showOpenDialog(new Stage());
  }

  /**
   * @return the data file the user selected.
   */
  public File getDataFile() {
    if (this.dataFile == null) {
      promptFileChooser();
//      throw new RuntimeException("Data file not selected!");
    }
    return this.dataFile;
  }

  // set some sensible defaults when the FileChooser is created
  private static javafx.stage.FileChooser makeChooser(String extensionAccepted) {
    javafx.stage.FileChooser result = new javafx.stage.FileChooser();
    result.setTitle("Open Data File");
    // pick a reasonable place to start searching for files
    result.setInitialDirectory(new File(DATA_FILE_FOLDER));
    result.getExtensionFilters()
        .setAll(new javafx.stage.FileChooser.ExtensionFilter("CSV Files", extensionAccepted));
    return result;
  }
}
