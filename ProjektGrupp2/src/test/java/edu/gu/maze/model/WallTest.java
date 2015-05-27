package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WallTest {
    Wall wall = new Wall();

    @Test
    public void testCanIMoveHere() {
        assertTrue(wall.canIMoveHere() == Constants.NO);
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        wall.clearWay();
    }

    @Test
    public void testToString() {
        String W = wall.toString();
        assertTrue(W.equals("W"));
    }
}
