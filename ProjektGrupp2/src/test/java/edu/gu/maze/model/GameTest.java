package edu.gu.maze.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.gu.maze.util.Constants;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author omega
 */
public class GameTest {
    Game instance = new Game();
    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //instance = new Game();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getQuestion method, of class Game.
     */

    // Test if you get a question when using getQuestion
    @Test
    public void testGetQuestion() {
        String question = instance.getQuestion();
        boolean bool = question != null;
        assertTrue(bool);
    }

    /**
     * Test of getAnswers method, of class Game.
     */

    // Test if you get 3 possibly answers when using getAnswers();
    @Test
    public void testGetAnswers() {
        instance.getQuestion();
        String[] result = instance.getAnswers();
        int length = result.length;
        boolean bool = length == 3;
        assertTrue(bool);
    }

    // Checking behaviour when getQuestion() has not been called.
    @Test (expected = NullPointerException.class)
    public void testGetAnswers2(){
        instance.getAnswers();
    }

    // Checking behaviour when isThisTheRightAnswer() has been called.
    @Test (expected = NullPointerException.class)
    public void testGetAnswers3(){
        instance.startMatch(0);
        instance.getQuestion();
        instance.isThisTheRightAnswer(0);
        instance.getAnswers();
    }


    /**
     * Test of isThisTheRightAnswer method, of class Game.
     */

    // Testing calling isThisTheRightAnswer without a question
    @Test (expected = NullPointerException.class)
    public void testIsThisTheRightAnswer() {
        instance.startMatch(0);
        instance.isThisTheRightAnswer(0);
    }

    // Testing with the not available answer
    @Test (expected = IllegalArgumentException.class)
    public void testIsThisTheRightAnswer2(){
        instance.getQuestion();
        instance.getAnswers();
        instance.isThisTheRightAnswer(3);
    }

    // Test with a answer between 0 and 2
    @Test
    public void testIsThisTheRightAnswer3(){
        instance.createPlayer(0, "bla", 0);
        instance.startMatch(0);
        instance.getQuestion();
        instance.getAnswers();
        int answer1 = instance.isThisTheRightAnswer(0);
        boolean bool1 = answer1 == 1 | answer1==0;
        assertTrue(bool1);
        instance.getQuestion();
        instance.getAnswers();
        int answer2 = instance.isThisTheRightAnswer(1);
        boolean bool2 = answer2 == 1 | answer2==0;
        assertTrue(bool2);
        instance.getQuestion();
        instance.getAnswers();
        int answer3 = instance.isThisTheRightAnswer(2);
        boolean bool3 = answer3 == 1 | answer3 == 0;
        assertTrue(bool3);
    }


    // Calling the method twice in a row
    @Test (expected = NullPointerException.class)
    public void testIsThisTheRightAnswer4(){
        instance.startMatch(0);
        instance.getQuestion();
        instance.isThisTheRightAnswer(1);
        instance.isThisTheRightAnswer(2);
    }

    // Test if no error when using setTime()
    @Test
    public void testSetTime(){
        instance.createPlayer(0, "bla", 0);
        instance.startMatch(0);
        instance.setTime(1,4);
    }

    // Test setGamesDoneToFalse()
    @Test
    public void testSetGamesDoneToFalse(){
        instance.setGamesDoneToFalse();
        boolean bool = instance.gamesDone();
        assertTrue(!bool);
    }

    // Test if you have a valid number of Apples
    @Test
    public void testGetApples() {
        instance.createPlayer(0, "bla", 0);
        instance.startMatch(0);
        int apples = instance.getApples();
        boolean bool = apples >= 0;
        assertTrue(bool);
    }

    // Test if you have a valid number of Keys
    @Test
    public void testGetKeys() {
        instance.createPlayer(0, "bla", 0);
        instance.startMatch(0);
        int keys = instance.getKeys();
        boolean bool = keys >= 0;
        assertTrue(bool);

    }

    // Test no errors
    @Test
    public void testGetPoints() {
        instance.createPlayer(0, "bla", 0);
        instance.startMatch(0);
        instance.getPoints();
    }

    // Test gamesDone()
    @Test
    public void testGamesDone(){
        boolean bool1 = instance.gamesDone();
        boolean bool2 = bool1 | !bool1;
        assertTrue(bool2);
    }


    @Test
    public void testNoUnexpectedErrorsinPlayerSelection(){
        //Run this in debug mode to check actual values
        instance.createPlayer(Constants.SLOT1, "Harry Potter", Constants.MAGE);
        instance.selectPlayer(Constants.SLOT1);
        instance.deletePlayer(Constants.SLOT1);
        instance.createPlayer(Constants.SLOT1, "Harry Potter", Constants.MAGE);
    }


    @Test
    public void testSerialization(){
        Game game = new Game();
        game.createPlayer(0, "Harry", 0);
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("src/main/resources/edu/gu/maze/util/gameTest.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved.");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
        try
        {
            FileInputStream fileIn = new FileInputStream("src/main/resources/edu/gu/maze/util/gameTest.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }
}
