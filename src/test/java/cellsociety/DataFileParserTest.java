package cellsociety;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cellsociety.controller.DataFileParser;
import java.util.Properties;
import org.junit.jupiter.api.Test;

/**
 * These tests verify that the DataFileParser class is able to extract the information from a sim
 * file and package it into a properties file.
 */

public class DataFileParserTest {

  @Test
  void testSimFileType() {
    Properties testType = DataFileParser.parseSimFile("data/fire/fire_center.sim");
    String test = "Fire";
    assertEquals(testType.getProperty("Type"), test);
  }

  @Test
  void testSimFileAuthor() {
    Properties testAuthor = DataFileParser.parseSimFile("data/fire/fire_center.sim");
    String test = "Robert Duvall";
    assertEquals(testAuthor.getProperty("Author"), test);
  }

  @Test
  void testSimFileTitle() {
    Properties testTitle = DataFileParser.parseSimFile("data/fire/fire_center.sim");
    String test = "Room to Burn";
    assertEquals(testTitle.getProperty("Title"), test);
  }

  @Test
  void testSimFileDescription() {
    Properties testDescription = DataFileParser.parseSimFile("data/fire/fire_center.sim");
    String test = "Fire in the center of the trees";
    assertEquals(testDescription.getProperty("Description"), test);
  }

  @Test
  void testSimFileInitialStates() {
    Properties testInitialStates = DataFileParser.parseSimFile("data/fire/fire_center.sim");
    String test = "fire/fire_center.csv";
    assertEquals(testInitialStates.getProperty("InitialStates"), test);
  }

  @Test
  void testSimFileParameters() {
    Properties testParameters = DataFileParser.parseSimFile("data/fire/fire_center.sim");
    double test = 0.4;
    assertEquals(Double.parseDouble(testParameters.getProperty("Parameters")), (test));
  }

  @Test
  void testSimFileStateColors() {
    Properties testStateColors = DataFileParser.parseSimFile("data/fire/one_burning.sim");
    String test = "6e4d07,1f8518,cf1f13";
    assertEquals(testStateColors.getProperty("StateColors"), test);
  }

}
