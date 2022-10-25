package cellsociety;

import java.util.ResourceBundle;
import cellsociety.view.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    public static final String INTERNAL_CONFIGURATION = "cellsociety.Configuration";

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

    /**
     * A method to test getting internal resources.
     */
    public double getVersion () {
        ResourceBundle resources = ResourceBundle.getBundle(INTERNAL_CONFIGURATION);
        return Double.parseDouble(resources.getString("Version"));
    }
}
