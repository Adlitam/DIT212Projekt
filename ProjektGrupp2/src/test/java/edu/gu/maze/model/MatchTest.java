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
public class MatchTest {
    Match match;
    HighScore score1, score2, score3, score4, score5, score6;
    //pubMatchTestTest() {
    //}
    
    @Before
    public void setUp() throws InterruptedException, FileNotFoundException{
        //map = neMatchap("map1.txt", 14, 11);
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

    // Test CorrectAnswer(), getApples(), getKeys() and getScore() ;
    @Test
    public void testCorrectAnswer(){
        match = new Match(new ISquare[10][10],6,6);
        match.correctAnswer();
        int apples = match.getApples();
        boolean bool1 = apples == 1;
        assertTrue(bool1);
        int keys = match.getKeys();
        boolean bool2 = keys==1;
        assertTrue(bool2);
        int score = match.getScore();
        boolean bool3 = score==5;
        assertTrue(bool3);
    }

    // Test wrongAnswer(), getApples(), getKeys() and getScore();
    @Test
    public void testWrongAnswer(){
        match = new Match(new ISquare[10][10],6,6);
        match.wrongAnswer();
        int apples = match.getApples();
        boolean bool1 = apples == 0;
        assertTrue(bool1);
        int keys = match.getKeys();
        boolean bool2 = keys==0;
        assertTrue(bool2);
        int score = match.getScore();
        boolean bool3 = score==-5;
        assertTrue(bool3);
    }

    // Test no error in setTime()
    @Test
    public void testSetTime(){
        match = new Match(new ISquare[10][10],6,6);
        match.setTime(10,10);
    }

    // Test no error in endMatch()
    @Test
    public void testEndMatch(){
        match = new Match(new ISquare[10][10],6,6);
        match.endMatch();
    }







    /**
     * Test of addHighScore method, of class Map.
     */
    /*@Test
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
    }*/
    
}
