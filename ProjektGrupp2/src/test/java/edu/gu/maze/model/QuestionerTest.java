package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class QuestionerTest {

    Questioner quest = new Questioner();

    @Test
    public void testCanIMoveHere() {
        boolean bool = quest.canIMoveHere() == Constants.QUESTIONER;
        assertTrue(bool);
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        quest.clearWay();
    }

    @Test
    public void testToString() {
        String Q = quest.toString();
        boolean bool = Q.equals("Questioner");
        assertTrue(bool);
    }


}
