package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class QuestionerTest {

    private final Questioner quest = new Questioner();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.QUESTIONER,quest.canIMoveHere());
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        quest.clearWay();
    }




}
