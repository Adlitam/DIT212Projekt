package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuestionerTest {

    Questioner quest = new Questioner();

    @Test
    public void testCanIMoveHere() {
        assertTrue(quest.canIMoveHere() == Constants.QUESTIONER);
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        quest.clearWay();
    }

    @Test
    public void testToString() {
        String Q = quest.toString();
        assertTrue(Q.equals("Questioner"));
    }


}
