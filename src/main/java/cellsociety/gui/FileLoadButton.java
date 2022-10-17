package cellsociety.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLoadButton {
    private Button loadFileBtn;
    private FileChooser fileChooser;
    private ImageView loadFileIcon;

    private static final String OPEN_BTN_FILE_NAME = "open_file_icon.png";
    private static final Path GUI_RESOURCES_PATH = Paths.get("src", "main", "resources", "cellsociety", "gui", "images", OPEN_BTN_FILE_NAME);
    private static final String BTN_IMG_FILE_PATH = GUI_RESOURCES_PATH.toFile().getAbsolutePath();

    public FileLoadButton(){
        loadFileBtn = new Button();
        System.out.println(BTN_IMG_FILE_PATH);
        fileChooser = new FileChooser();
//        loadFileIcon = new ImageView(new Image(BTN_IMG_FILE_PATH));
//        loadFileBtn.setGraphic(loadFileIcon);

        // TODO: Use resources!!!
        loadFileBtn.setPrefHeight(50);
        loadFileBtn.setPrefWidth(50);

        loadFileBtn.setOnAction(this::openFileChooser);
    }

    private void openFileChooser(ActionEvent e){
        System.out.println("File opener prompted...");
        fileChooser.promptFileChooser();
    }


    public Button getLoadFileBtn(){
        return loadFileBtn;
    }
}
