package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuestionerTest {

    Questioner quest = new Questioner();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.QUESTIONER,quest.canIMoveHere());
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        quest.clearWay();
    }

    @Test
    public void testToString() {
        String Q = quest.toString();
        assertEquals("Questioner",Q);
    }


}
