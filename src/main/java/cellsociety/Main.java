package cellsociety;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ResourceBundle;

import cellsociety.gui.GUI;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    /**
     * @see Application#start(Stage)
     */
    @Override
    public void start (Stage primaryStage) {
        GUI gui = new GUI();
        CellSociety cellSociety = new CellSociety();

        primaryStage.setScene(gui.setupScene());
        primaryStage.setTitle("Cell Society");
        primaryStage.show();
    }
}
