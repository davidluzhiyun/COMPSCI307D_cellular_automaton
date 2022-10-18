package cellsociety.gui.buttons;

import cellsociety.gui.GUI;
import cellsociety.gui.GUIPropertiesLoader;
import cellsociety.gui.LoadFileBtn;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ResourceBundle;

public abstract class GUIBtn {
    private Button btn;
    private ImageView icon;

    public GUIBtn(String btnText, String iconID){
        ResourceBundle iconResources = ResourceBundle.getBundle(GUI.GUI_ICON_PROPERTIES);
        InputStream iconPath = LoadFileBtn.class.getClassLoader().getResourceAsStream(
                                    iconResources.getString(iconID));

        GUIPropertiesLoader properties = new GUIPropertiesLoader();
        icon = new ImageView(new Image(iconPath));
        icon.setFitWidth(properties.getButtonProperty("defaultGraphicWidth"));
        icon.setFitHeight(properties.getButtonProperty("defaultGraphicHeight"));

        btn = new Button(btnText);
        btn.setGraphic(icon);
        btn.resize(properties.getButtonProperty("defaultBtnWidth"),
                properties.getButtonProperty("defaultBtnHeight"));


    }
    protected void setOnClickEvent(EventHandler<ActionEvent> actionEvent) {
        btn.setOnAction(actionEvent);
    }

    public Button getBtn(){
        return btn;
    }

}
