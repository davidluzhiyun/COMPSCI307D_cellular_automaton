package cellsociety;

import cellsociety.controller.DataFileParser;
import java.io.File;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import javax.xml.crypto.Data;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Feel free to completely change this code or delete it entirely. 
 */
class MainTest {
    // how close do real valued numbers need to be to count as the same
    static final double TOLERANCE = 0.0005;


    @Test
    void testVersionIsReady () {
    	Main m = new Main();
	    // different ways to test double results
        assertEquals(1, Math.round(m.getVersion() * 1000));
        assertTrue(m.getVersion() < 1);
        assertEquals(0.001, m.getVersion(), TOLERANCE);
    }
    @Test
    void testSimFileType(){
        Properties testType = DataFileParser.dataFileParser("data/game_of_life/blinkers.sim");
    String test = "GameOfLife";
    assertTrue(testType.getProperty("Type").equals(test));
    }
    @Test
    void testSimFileAuthor(){
        Properties testAuthor = DataFileParser.dataFileParser("data/game_of_life/blinkers.sim");
        String test = "John Conway";
        assertTrue(testAuthor.getProperty("Author").equals(test));
    }

//    @Test
//    void testCSVDataSum () {
//        String csvData = """
//                width,height
//                1,1,1,1,1,1,1,1,1,1
//                1,1,1,1,1,1,1,1,1,1
//                1,1,1,1,1,1,1,1,1,1
//                1,1,1,1,1,1,1,1,1,1
//                """;
//
//        Main m = new Main();
//        assertEquals(40, m.sumCSVData(new StringReader(csvData)));
//    }
}
