package cellsociety;


import cellsociety.controller.CellSociety;
import cellsociety.controller.Controller;
import cellsociety.controller.SplashController;
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
    public Stage mainStage;

    private SplashController splashController = new SplashController();

    /**
     * @see Application#start(Stage)
     */
    @Override
    public void start (Stage primaryStage) {
        splashController.saveMainStage(primaryStage);
        SplashScreen startupScreen = new SplashScreen(splashController);
        primaryStage.setTitle(startupScreen.SPLASH_TITLE);
        primaryStage.setScene(startupScreen.createScene());
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
