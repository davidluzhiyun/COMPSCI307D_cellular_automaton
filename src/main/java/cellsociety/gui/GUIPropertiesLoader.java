package cellsociety.gui;

import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

/**
 * @author dm396
 */
public class GUIPropertiesLoader {
    private final ResourceBundle GUI_PROPERTIES = ResourceBundle.getBundle("cellsociety.properties.GUIProperties");
    private final ResourceBundle BUTTON_PROPERTIES = ResourceBundle.getBundle("cellsociety.properties.ButtonSettings");

    //todo: add properties, such as button sizes, pane dimensions, etc.

    public GUIPropertiesLoader(){
    }

    public int getGUIProperty(String key){
        return parseInt(GUI_PROPERTIES.getString(key));
    }


    public int getButtonProperty(String key){
        return parseInt(BUTTON_PROPERTIES.getString(key));
    }
}
