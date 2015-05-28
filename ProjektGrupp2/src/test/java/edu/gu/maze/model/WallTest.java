package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WallTest {
    Wall wall = new Wall();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.NO,wall.canIMoveHere());
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        wall.clearWay();
    }

    @Test
    public void testToString() {
        String W = wall.toString();
        assertEquals("W",W);
    }
}
