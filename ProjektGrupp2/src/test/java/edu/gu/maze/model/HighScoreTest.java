package edu.gu.maze.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omega
 */
public class HighScoreTest {
    
    public HighScoreTest() {
    }
    
    @Before
    public void setUp() {
        HighScore one = new HighScore("Harry", 10);
    }
    
    @After
    public void tearDown() {
    }

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
        assert (i==1);
        assert (j==-1);
    }
    
    //Same score, different time
    @Test
    public void testCompareTo2() throws InterruptedException{
        HighScore one = new HighScore("Draco", 10);
        Thread.sleep(5000);
        HighScore two = new HighScore("Harry", 10);
        int i = one.compareTo(two);
        int j = two.compareTo(one);
        System.out.println(i);
        assert (i>0);
        assert (j<0);
    }
    
}
