package cellsociety.controller;

import java.util.Properties;

public interface SimInfoProps {

  Properties parseSimFileProvided(String fileName, Boolean checkRequiredInfo);

}
