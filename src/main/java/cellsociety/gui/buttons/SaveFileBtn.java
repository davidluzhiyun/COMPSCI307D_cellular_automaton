package cellsociety.gui.buttons;

import javafx.event.ActionEvent;

public class SaveFileBtn extends GUIBtn{
    public SaveFileBtn(String btnText, String iconID) {
        super(btnText, iconID);
        this.setOnClickEvent(this::event);
    }

    private void event(ActionEvent actionEvent) {
        System.out.println("Save file button pressed!");
    }

}
