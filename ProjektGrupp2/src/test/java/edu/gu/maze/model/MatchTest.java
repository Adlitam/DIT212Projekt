package edu.gu.maze.model;


import static org.junit.Assert.*;
import org.junit.Test;


public class MatchTest {
    ISquare[][] squares = {{new Wall(), new FinalDoor(), new Wall()},
            {new Wall(), new Chest(), new Wall()},
            {new Questioner(), new Road(), new Monster()},
            {new Wall(), new Door(), new Wall()}
    };
    final private Match match = new Match(squares, 1, 2);


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

    @Test
    public void testGetX() {
        assertEquals(match.getX(), 1);

    }

    @Test
    public void testGetY() {
        assertEquals(match.getY(), 2);

    }
    
    @Test
    public void testIsFinalKey(){
        assertFalse(match.isFinalKey());
        match.correctAnswer();
        assertTrue(match.isFinalKey());
    }
    
    @Test
    public void testEndMatch(){
        match.endMatch();
        assertEquals(500, match.getScore());
    }
    
    @Test
    public void testMoveOntoMonsterWithoutApple(){
        
    }
    
    public void testMoveOntoMonsterWithApple(){
        
    }
    
    public void testMoveOntoDoorWithoutKey(){
        
    }
    
    public void testMoveOntoDoorWithKey(){
        
    }
}
