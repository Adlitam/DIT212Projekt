package edu.gu.maze.model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class HighScoreTest {
    

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

    @Test
    public void testGetScore(){
        final HighScore high = new HighScore("Harry", 12);
        final int score = high.getScore();
        assertEquals(12,score);


    }

    @Test
    public void testToString(){
        final HighScore high = new HighScore("Harry", 12);
        final String test = high.toString();
        assertNotEquals(null, test);


    }



    
}
