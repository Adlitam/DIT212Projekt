package edu.gu.maze.model;


import org.junit.Test;


/**
 *
 * @author omega
 */
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
        boolean bool1 =i==1;
        boolean bool2 =j==-1;
        assert (bool1);
        assert (bool2);
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

        boolean bool1 = i>0;
        boolean bool2 = j<0;
        assert (bool1);
        assert (bool2);
    }
    
}
