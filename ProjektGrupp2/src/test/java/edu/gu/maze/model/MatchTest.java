package edu.gu.maze.model;


import static edu.gu.maze.util.Constants.*;
import static org.junit.Assert.*;
import org.junit.Test;


public class MatchTest {
    private ISquare[][] squares = {{new Wall(), new FinalDoor(), new Wall()},
            {new Wall(), new Door(), new Wall()},
            {new Questioner(), new Road(), new Monster()},
            {new Wall(), new Chest(), new Wall()}
    };
    private final Match match = new Match(squares, 1, 2);


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
        final int i = match.moveRight();
        assertTrue (i==APPLE && match.getX() == 1 && match.getY()==2);
    }
    
    @Test
    //This one also tests moveRight()
    public void testMoveOntoMonsterWithApple(){
        //Get apple from chest
        final int j = match.moveDown();
        //give apple to monster
        final int i = match.moveRight();
        //move onto monster's square
        match.moveRight();
        //take a step back
        match.moveLeft();
        assertTrue (j==CHEST && i==GOTAPPLE && match.getX() == 1 && match.getY()==2);
    }
    
    @Test
    public void testMoveOntoDoorWithoutKey(){
        final int i = match.moveUp();
        assertTrue (i==KEY && match.getX() == 1 && match.getY()==2);
    }
    
    //Also tests moveUp() and moveDown()
    @Test
    public void testMoveOntoDoorWithKey(){
        //Get key from chest
        match.moveDown();
        //unlock the door
        final int i = match.moveUp();
        //go through door
        match.moveUp();
        //take a step back
        final int j = match.moveDown();       
        assertTrue (j==YES && i==GOTKEY && match.getX() == 1 && match.getY()==2);
    }
    
    @Test
    public void testIntentionalBug(){
        for (int i =0; i<1000; i++){
            match.moveRight();
        }
        assertTrue (match.getScore() == 1000000 && match.getApples()==1000000 && match.getKeys()==1000000);
    }
}
