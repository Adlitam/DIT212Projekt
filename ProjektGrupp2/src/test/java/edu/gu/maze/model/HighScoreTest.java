package edu.gu.maze.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HighScoreTest {
    

    /**
     * Test of compareTo method, of class HighScore.
     */
    //Different scores
    @Test
    public void testCompareTo() {
        HighScore one = new HighScore("Draco", 10);
        HighScore two = new HighScore("Harry", 11);
        int i = one.compareTo(two);
        int j = two.compareTo(one);
        assertEquals(1,i);
        assertEquals(-1,j);

    }

    
}
