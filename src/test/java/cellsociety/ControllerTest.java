package cellsociety;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import cellsociety.controller.Controller;
import cellsociety.controller.DataFileParser;
import java.util.List;
import java.util.Properties;
import org.junit.jupiter.api.Test;

public class ControllerTest {

  private Controller controller;
  @Test
  void testHeightandWidthCorrect() {
    Properties simulationProps = DataFileParser.parseSimFile("data/schelling/diagonal.sim");
    List<String[]> gridStates = DataFileParser.readAllCSVDataAtOnce("data/" + simulationProps.getProperty("InitialStates"));
    int gridHeight = Integer.parseInt(gridStates.get(0)[1]);
    int gridWidth = Integer.parseInt(gridStates.get(0)[0]);
    assertEquals(8, gridHeight);
    assertEquals(8, gridWidth);
  }

  @Test
  void testHeightandWidthNotInverted() {
    Properties simulationProps = DataFileParser.parseSimFile("data/game_of_life/penta_decathlon.sim");
    List<String[]> gridStates = DataFileParser.readAllCSVDataAtOnce("data/" + simulationProps.getProperty("InitialStates"));
    int gridHeight = Integer.parseInt(gridStates.get(0)[1]);
    int gridWidth = Integer.parseInt(gridStates.get(0)[0]);
    assertNotEquals(11, gridHeight);
    assertNotEquals(18, gridWidth);
    assertEquals(18, gridHeight);
    assertEquals(11, gridWidth);
  }

}
