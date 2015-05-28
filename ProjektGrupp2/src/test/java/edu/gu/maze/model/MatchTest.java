package edu.gu.maze.model;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omega
 */
public class MatchTest {
    Match match;


    // Test CorrectAnswer(), getApples(), getKeys() and getScore() ;
    @Test
    public void testCorrectAnswer(){
        match = new Match(new ISquare[10][10],6,6);
        match.correctAnswer();
        int apples = match.getApples();
        assertEquals(1,apples);
        int keys = match.getKeys();
        assertEquals(1,keys);
        int score = match.getScore();
        assertEquals(5,score);
    }

    // Test wrongAnswer(), getApples(), getKeys() and getScore();
    @Test
    public void testWrongAnswer(){
        match = new Match(new ISquare[10][10],6,6);
        match.wrongAnswer();
        int apples = match.getApples();
        assertEquals(0,apples);
        int keys = match.getKeys();
        assertEquals(0,keys);
        int score = match.getScore();
        assertEquals(-5,score);
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


    
}
