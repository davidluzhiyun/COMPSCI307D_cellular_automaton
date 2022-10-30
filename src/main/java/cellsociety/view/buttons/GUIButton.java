package cellsociety.view.buttons;

import cellsociety.view.GUI;
import cellsociety.view.GUIPropertiesLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;

import java.io.InputStream;
import java.util.ResourceBundle;

/**
 * Creates a button with a graphic by using resources and default property settings.
 *
 * @author dm396
 */
public abstract class GUIButton {

  private Button button;
  private Text buttonText;
  private VBox buttonContainer;
  private ImageView icon;

  /**
   * Creates a JavaFX button with a specified graphic
   *
   * @param buttonText the button's text
   * @param iconID     the RESOURCE name that maps the icon's filepath
   */
  public GUIButton(String buttonText, String iconID) {
    GUIPropertiesLoader properties = new GUIPropertiesLoader();

    // load the graphic using resources
    ResourceBundle iconResources = ResourceBundle.getBundle(GUI.GUI_ICON_PROPERTIES);
    InputStream iconPath = GUIButton.class.getClassLoader().getResourceAsStream(
        iconResources.getString(iconID));
    buttonContainer = new VBox();

    // set icon graphic appearances
    if (iconPath == null) {
      throw new NullPointerException("Invalid button icon path");
    }
    icon = new ImageView(new Image(iconPath));
    icon.setFitWidth(properties.getButtonProperty("defaultGraphicWidth"));
    icon.setFitHeight(properties.getButtonProperty("defaultGraphicHeight"));

    // set up button
    button = new Button();
    button.setGraphic(icon);

    this.buttonText = new Text(buttonText);
    this.buttonText.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
    buttonContainer.getChildren().addAll(button, this.buttonText);
    buttonContainer.setAlignment(Pos.CENTER);
  }

  /**
   * Sets the button's on-click event
   *
   * @param actionEvent method to run when the button is pressed
   */
  protected void setOnClickEvent(EventHandler<ActionEvent> actionEvent) {
    button.setOnAction(actionEvent);
  }

  /**
   * @return a Button object
   */
  public Node getButton() {
    return buttonContainer;
  }

}
