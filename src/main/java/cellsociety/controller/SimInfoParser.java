package cellsociety.controller;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SimInfoParser implements SimInfoProps {

  private static final List<String> REQUIRED_GAME_INFO = List.of("Type", "Author",
      "Description", "InitialStates", "Title");


  public Properties parseSimFileProvided(String fileName, Boolean checkRequiredInfo) {
    Properties simInfoProps = new Properties();
    try {
      FileReader reader = new FileReader(fileName);
      simInfoProps.load(reader);
      if (checkRequiredInfo && !simInfoProps.keySet().containsAll(REQUIRED_GAME_INFO)) {

        // NEED TO MAKE THIS OUR OWN ERROR FROM PROPERTIES FILE
        throw new Exception();
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return simInfoProps;
  }

}
