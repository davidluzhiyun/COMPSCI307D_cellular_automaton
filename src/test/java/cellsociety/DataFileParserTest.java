package cellsociety;

import static org.junit.jupiter.api.Assertions.assertTrue;

import cellsociety.controller.DataFileParser;
import java.util.Properties;
import org.junit.jupiter.api.Test;

public class DataFileParserTest {

  @Test
  void testSimFileType(){
    Properties testType = DataFileParser.dataFileParser("data/fire/fire_center.sim");
    String test = "Fire";
    assertTrue(testType.getProperty("Type").equals(test));
  }
  @Test
  void testSimFileAuthor(){
    Properties testAuthor = DataFileParser.dataFileParser("data/fire/fire_center.sim");
    String test = "Robert Duvall";
    assertTrue(testAuthor.getProperty("Author").equals(test));
  }
  @Test
  void testSimFileTitle(){
    Properties testTitle = DataFileParser.dataFileParser("data/fire/fire_center.sim");
    String test = "Room to Burn";
    assertTrue(testTitle.getProperty("Title").equals(test));
  }
  @Test
  void testSimFileDescription(){
    Properties testDescription = DataFileParser.dataFileParser("data/fire/fire_center.sim");
    String test = "Fire in the center of the trees";
    assertTrue(testDescription.getProperty("Description").equals(test));
  }
  @Test
  void testSimFileInitialStates(){
    Properties testInitialStates = DataFileParser.dataFileParser("data/fire/fire_center.sim");
    String test = "fire/fire_center.csv";
    assertTrue(testInitialStates.getProperty("InitialStates").equals(test));
  }
  @Test
  void testSimFileParameters(){
    Properties testParameters = DataFileParser.dataFileParser("data/fire/fire_center.sim");
    double test = 0.4;
    assertTrue(Double.parseDouble(testParameters.getProperty("Parameters"))==(test));
  }
  @Test
  void testSimFileStateColors(){
    Properties testStateColors = DataFileParser.dataFileParser("data/fire/one_burning.sim");
    String test = "6e4d07,1f8518,cf1f13";
    assertTrue(testStateColors.getProperty("StateColors").equals(test));
  }

}
