package edu.gu.maze.util;

import edu.gu.maze.model.Question;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omega
 */
public class ResourceReaderTest {
    
    public ResourceReaderTest() {
    }

    /**
     * Test of readMapForModel method, of class ResourceReader.
     */
    @Test
    public void testReadMapForModel() {
    }

    /**
     * Test of readQuestions method, of class ResourceReader.
     */
    @Test
    public void testReadQuestions() {
        Question[] q = ResourceReader.readQuestions();
    }
    
}
