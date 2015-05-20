package edu.gu.maze.model;

import java.io.FileNotFoundException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author omega
 */
public class MapTest {
    Map map;
    HighScore score1, score2, score3, score4, score5, score6;
    public MapTest() {
    }
    
    @Before
    public void setUp() throws InterruptedException, FileNotFoundException{
<<<<<<< HEAD
        //map = new Map("map1.txt");
=======
        map = new Map("map1.txt", 14, 11);
>>>>>>> 24ec1c4c3aaf59d62bd3507a0779b82b3885b100
        score1 = new HighScore("Harry", 10);
        score2 = new HighScore ("Draco", 11);
        score3 = new HighScore ("Draco", 13);
        Thread.sleep(5000);
        score4 = new HighScore ("Draco", 11);
        score5 = new HighScore ("Draco", 9);
        score6 = new HighScore ("Draco", 20);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addHighScore method, of class Map.
     */
    @Test
    public void testAddHighScore() {
        map.addHighScore(score1);
        map.addHighScore(score2);
        map.addHighScore(score3);
        map.addHighScore(score4);
        map.addHighScore(score5);
        map.addHighScore(score6);
        //for (HighScore h : map.scores){
            System.out.println(map);
        //}
    }
    
}
