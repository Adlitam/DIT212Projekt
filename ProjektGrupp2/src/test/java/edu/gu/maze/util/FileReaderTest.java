package edu.gu.maze.util;

import edu.gu.maze.model.Match;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author omega
 */
public class FileReaderTest {
    
    public FileReaderTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of readMapForModel method, of class FileReader.
     */
    @Test
    public void testReadMapForModel() {
        Match match = ResourceReader.readMapForModel("src/main/resources/edu/gu/maze/util/Level1.txt");
    }
    
}
