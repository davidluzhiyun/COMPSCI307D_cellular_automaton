package cellsociety.view.buttons;

import cellsociety.view.GUI;
import cellsociety.view.GUIPropertiesLoader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ResourceBundle;

/**
 * Creates a button with a graphic by using resources and default
 * property settings.
 *
 * @author dm396
 */
public abstract class GUIButton {
    private Button btn;
    private ImageView icon;

    /**
     * Creates a JavaFX button with a specified graphic
     * @param btnText the button's text
     * @param iconID the RESOURCE name that maps the icon's filepath
     */
    public GUIButton(String btnText, String iconID){
        GUIPropertiesLoader properties = new GUIPropertiesLoader();

        // load the graphic using resources
        ResourceBundle iconResources = ResourceBundle.getBundle(GUI.GUI_ICON_PROPERTIES);
        InputStream iconPath = LoadFileButton.class.getClassLoader().getResourceAsStream(
                                    iconResources.getString(iconID));

        // set icon graphic appearances
        icon = new ImageView(new Image(iconPath));
        icon.setFitWidth(properties.getButtonProperty("defaultGraphicWidth"));
        icon.setFitHeight(properties.getButtonProperty("defaultGraphicHeight"));

        // set up button
        btn = new Button(btnText);
        btn.setGraphic(icon);
        btn.resize(properties.getButtonProperty("defaultBtnWidth"),
                properties.getButtonProperty("defaultBtnHeight"));
    }

    /**
     * Sets the button's on-click event
     * @param actionEvent method to run when the button is pressed
     */
    protected void setOnClickEvent(EventHandler<ActionEvent> actionEvent) {
        btn.setOnAction(actionEvent);
    }

    /**
     * @return a Button object
     */
    public Button getBtn(){
        return btn;
    }

}
