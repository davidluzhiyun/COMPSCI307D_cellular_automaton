package cellsociety.gui.buttons;

import cellsociety.gui.FileChooser;
import cellsociety.gui.GUI;
import cellsociety.gui.GUIPropertiesLoader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;

import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

/**
 *
 * @author dm396
 */
public class LoadFileBtn extends GUIBtn{
    private FileChooser fileChooser;

    public LoadFileBtn(String btnText, String iconID) {
        super(btnText, iconID);

        fileChooser = FileChooser.getInstance();
        this.setOnClickEvent(this::openFileChooser);
    }

    private void openFileChooser(ActionEvent e){
        System.out.println("File opener prompted...");
        fileChooser.promptFileChooser();
    }


}
