package cellsociety.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ResourceBundle;

public class SaveFileBtn {
    private Button loadFileBtn;
    private ImageView loadFileIcon;

    private GUIPropertiesLoader properties;

    private final ResourceBundle ICON_RESOURCES = ResourceBundle.getBundle(GUI.GUI_ICON_PROPERTIES);
    private final InputStream SAVE_FILE_ICON_PATH = LoadFileBtn.class.getClassLoader().getResourceAsStream(
                                                    ICON_RESOURCES.getString("saveFileIconPath"));
    public SaveFileBtn(){
        properties = new GUIPropertiesLoader();

        loadFileBtn = new Button();

        loadFileIcon = new ImageView(new Image(SAVE_FILE_ICON_PATH));
        loadFileIcon.setFitWidth(properties.getButtonProperty("defaultGraphicWidth"));
        loadFileIcon.setFitHeight(properties.getButtonProperty("defaultGraphicHeight"));


        loadFileBtn.setGraphic(loadFileIcon);
        // TODO: Use resources!!!
        loadFileBtn.resize(properties.getButtonProperty("defaultBtnWidth"),
                properties.getButtonProperty("defaultBtnHeight"));

        loadFileBtn.setOnAction(this::openFileChooser);
    }

    private void openFileChooser(ActionEvent e){
        System.out.println("File opener prompted...");
    }


    public Button getBtn(){
        return loadFileBtn;
    }
}
