package cellsociety.view.grid;

import cellsociety.view.GUI;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * Maintains a mapping of cell states and colors, wherein a state (represented by an integer)
 * corresponds directly to a Color object. The mapping is re-mappable.
 * @author diego
 */
public class GridCellColorMap {
    private Map<Integer, Color> colorMap;
    private static final int MAX_STATES = 10;

    public GridCellColorMap(int numberOfStates){
        if(numberOfStates > MAX_STATES){throw new RuntimeException("Only 10 states allowed per simulation.");}

        colorMap = new HashMap<>();
        for(int colorIndex = 0; colorIndex < numberOfStates; colorIndex++){
            String color = GUI.properties.getColorProperty(colorIndex);
            colorMap.put(colorIndex, Color.web(color));
//            System.out.println(colorIndex + " " + color); //TODO: use this in your testing!
        }
    }

    public Color getColor(int colorIndex){
        return colorMap.get(colorIndex);
    }

    public void replaceColor(int key, String color){
        colorMap.put(key, Color.web(color));
    }
}

