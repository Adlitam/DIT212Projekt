package edu.gu.maze.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omega
 */
public class GameTest {
    Game instance;
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
    //TODO: Test what happens with unexpected input.
    @Test
    public void testGetQuestion() {
        //TODO: update this when Game is updated to have several questions.
        System.out.println("getQuestion");
        String expResult = "What is Gilderoy Lockhart's favourite colour?";
        String result = instance.getQuestion();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnswers method, of class Game.
     */
    @Test
    public void testGetAnswers() {
        //TODO: update this when Game is updated to have several questions.
        System.out.println("getAnswers");
        instance.getQuestion();
        String[] expResult = new String[]{"Pink", "Lilac", "Gold"};
        String[] result = instance.getAnswers();
        assertArrayEquals(expResult, result);
    }
    
    //Checking behaviour when getQuestion() has not been called.
    @Test (expected = NullPointerException.class)
    public void testGetAnswers2(){
        instance.getAnswers();
    }
    //Checking behaviour when isThisTheRightAnswer() has been called.
    @Test (expected = NullPointerException.class)
    public void testGetAnswers3(){
        instance.getQuestion();
        instance.isThisTheRightAnswer(0);
        instance.getAnswers();
    }
    

    /**
     * Test of isThisTheRightAnswer method, of class Game.
     */
    //Testing with the correct input
    @Test
    public void testIsThisTheRightAnswer() {
        System.out.println("isThisTheRightAnswer");
        instance.getQuestion();
        int[] expResult = new int[] {1,0,0,1,5};
        int[] result = instance.isThisTheRightAnswer(1);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //Testing with the wrong input
    @Test
    public void testIsThisTheRightAnswer2(){
        instance.getQuestion();
        int[] expResult = new int[] {0,0,0,0,0};
        int[] result = instance.isThisTheRightAnswer(2);
        assertArrayEquals(expResult, result);
    }
    
    //Test with nonexistent answer
    @Test (expected = IllegalArgumentException.class)
    public void testIsThisTheRightAnswer3(){
        instance.getQuestion();
        instance.isThisTheRightAnswer(5);
    }
    //Calling the method twice in a row
    @Test (expected = NullPointerException.class)
    public void testIsThisTheRightAnswer4(){
        instance.getQuestion();
        instance.isThisTheRightAnswer(1);
        instance.isThisTheRightAnswer(2);
    }
    
    @Test 
    public void testNoUnexpectedErrorsinPlayerSelection(){
        //Run this in debug mode to check actual values
        instance.createPlayer(Constants.SLOT1, "Harry Potter", Constants.MAGE, 14, 11);
        instance.selectPlayer(Constants.SLOT1);
        instance.deletePlayer(Constants.SLOT1);
        instance.createPlayer(Constants.SLOT1, "Harry Potter", Constants.MAGE, 14, 11);
    }
}
