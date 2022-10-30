package cellsociety;


import cellsociety.controller.CellSociety;
import cellsociety.view.SplashScreen;
import java.util.ResourceBundle;
import cellsociety.view.GUI;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Feel free to completely change this code or delete it entirely. 
 */
public class Main extends Application {
    public static final String INTERNAL_CONFIGURATION = "cellsociety.Configuration";

    // HAVE TO FIX THIS MAKE NONSTATIC
    public static Stage mainStage;
    /**
     * @see Application#start(Stage)
     */
    @Override
    public void start (Stage primaryStage) {
        saveMainStage(primaryStage);
        SplashScreen startupScreen = new SplashScreen();
        primaryStage.setTitle(startupScreen.SPLASH_TITLE);
        primaryStage.setScene(startupScreen.createScene());
        primaryStage.show();

        /* Creating a splash instead that we can use through the controller to dynamically
        Change how the GUI works and the about sections of it depending on game choice
        */

        /*
        GUI gui = new GUI();
        CellSociety cellSociety = new CellSociety();

        primaryStage.setScene(gui.setupScene());
        primaryStage.setTitle("Cell Society");
        primaryStage.show();
    }
         */
    }

    /**
     * A method to test getting internal resources.
     */
    public double getVersion () {
        ResourceBundle resources = ResourceBundle.getBundle(INTERNAL_CONFIGURATION);
        return Double.parseDouble(resources.getString("Version"));
    }

    public void saveMainStage(Stage stage) {
        this.mainStage = stage;
    }

    public static void startGUI() {
        GUI gui = new GUI();
        CellSociety cellSociety = new CellSociety();

        mainStage.setScene(gui.setupScene());
        mainStage.setTitle("Cell Society");
        mainStage.show();
    }
}
