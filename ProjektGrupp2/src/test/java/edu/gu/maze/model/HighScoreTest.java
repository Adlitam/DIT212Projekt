package edu.gu.maze.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HighScoreTest {
    

    /**
     * Test of compareTo method, of class HighScore.
     */
    //Different scores
    @Test
    public void testCompareTo() {
        final HighScore one = new HighScore("Draco", 10);
        final HighScore two = new HighScore("Harry", 11);
        final int i = one.compareTo(two);
        final int j = two.compareTo(one);
        assertEquals(1,i);
        assertEquals(-1,j);

    }

    
}
