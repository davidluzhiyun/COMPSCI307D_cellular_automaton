package cellsociety.gui;

import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class GUIPropertiesLoader {
    private final ResourceBundle BUTTON_PROPERTIES = ResourceBundle.getBundle("cellsociety.properties.ButtonSettings");

    //todo: add properties, such as button sizes, pane dimensions, etc.

    public GUIPropertiesLoader(){

    }


    public int getButtonProperty(String key){
        return parseInt(BUTTON_PROPERTIES.getString(key));
    }
}
