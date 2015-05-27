package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class WallTest {
    Wall wall = new Wall();

    @Test
    public void testCanIMoveHere() {
        boolean bool = wall.canIMoveHere() == Constants.NO;
        assertTrue(bool);
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        wall.clearWay();
    }

    @Test
    public void testToString() {
        String W = wall.toString();
        boolean bool = W.equals("W");
        assertTrue(bool);
    }
}
