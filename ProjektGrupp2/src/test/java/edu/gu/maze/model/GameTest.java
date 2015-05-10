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
        Game instance = new Game();
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
        Game instance = new Game();
        instance.getQuestion();
        String[] expResult = new String[]{"Pink", "Lilac", "Gold"};
        String[] result = instance.getAnswers();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of isThisTheRightAnswer method, of class Game.
     */
    @Test
    public void testIsThisTheRightAnswer() {
        System.out.println("isThisTheRightAnswer");
        int index = 0;
        Game instance = new Game();
        instance.getQuestion();
        int[] expResult = new int[] {1,0,0,1,5};
        int[] result = instance.isThisTheRightAnswer(1);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
