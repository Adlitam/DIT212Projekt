package edu.gu.maze.model;


import static org.junit.Assert.*;
import org.junit.Test;


public class MatchTest {
    final private Match match = new Match(new ISquare[10][10],6,6);


    // Test CorrectAnswer(), getApples(), getKeys() and getScore() ;
    @Test
    public void testCorrectAnswer(){
        match.correctAnswer();
        final int apples = match.getApples();
        assertEquals(1,apples);
        final int keys = match.getKeys();
        assertEquals(1,keys);
        final int score = match.getScore();
        assertEquals(5,score);
    }

    // Test wrongAnswer(), getApples(), getKeys() and getScore();
    @Test
    public void testWrongAnswer(){
        match.wrongAnswer();
        final int apples = match.getApples();
        assertEquals(0,apples);
        final int keys = match.getKeys();
        assertEquals(0,keys);
        final int score = match.getScore();
        assertEquals(-5,score);
    }

    // Test no error in setTime()
    @Test
    public void testSetTime(){
        match.setTime(10,10);
    }

    // Test no error in endMatch()
    @Test
    public void testEndMatch(){
        match.endMatch();
    }


    
}
