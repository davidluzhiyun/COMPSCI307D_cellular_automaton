package cellsociety.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class ActionInputConstructor extends HBox {

  /**
   * Create input with given label and method to call on the given Controller.
   */
  public ActionInputConstructor (String promptText, String methodName, Controller target) {
    getChildren().addAll(makePrompt(promptText),
        makeInputAction(target, methodName));
  }

  // make input prompt, very basic for now but could be much more involved in general
  private Node makePrompt (String text) {
    return new Label(text + "\t");
  }

  // make input field that calls Controller method using reflection as its action
  private Node makeInputAction (Controller target, String methodName) {
    TextField result = new TextField();
    result.setOnAction(handler -> {
      try {
        // find method with given name that takes String as its only parameter
        Method m = target.getClass().getDeclaredMethod(methodName, String.class);
        m.invoke(target, result.getText());
        result.clear();
      }
      catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        // FIXME: typically make your own custom exception to throw
        throw new RuntimeException("Improper configuration", e);
      }
    });
    return result;
  }
}

}
