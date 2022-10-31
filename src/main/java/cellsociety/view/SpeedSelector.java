package cellsociety.view;


import java.io.InputStream;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author dm396
 */
public class SpeedSelector {

  // load the graphic using resources
  private final InputStream iconPath = SpeedSelector.class.getClassLoader().getResourceAsStream(
      ResourceBundle.getBundle(GUI.GUI_ICON_PROPERTIES).getString("speed"));  //TODO: Use resources

  private final ObservableList<Double> SPEED_OPTIONS =
      FXCollections.observableArrayList(0.5, 1.0, 2.0, 3.0);

  private VBox graphicsContainer;
  private ComboBox<Double> comboBox;
  private ImageView icon;
  private Text label;

  private int iconHeight = 35;
  private int iconWidth = 60;


  /**
   * Creates a combo box that enables the user to select between multiple animation speeds
   */
  public SpeedSelector() {
    graphicsContainer = new VBox();
    comboBox = new ComboBox<>(SPEED_OPTIONS);
    comboBox.setValue(1.0);
    label = new Text("Simulation Speed");


    // set icon graphic appearances
    if (iconPath == null) {
      throw new NullPointerException("Invalid button icon path");
    }
    icon = new ImageView(new Image(iconPath));
    icon.setFitHeight(iconHeight);  //TODO: Use resources
    icon.setFitWidth(iconWidth);   //TODO: Use resources
  }

  public void setAction(EventHandler<ActionEvent> event){
    comboBox.setOnAction(event);
  }

  public Node getGraphic() {
    graphicsContainer.getChildren().addAll(icon, comboBox, label);
    graphicsContainer.setAlignment(Pos.CENTER);
    return graphicsContainer;
  }
}
