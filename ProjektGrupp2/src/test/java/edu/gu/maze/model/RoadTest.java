package edu.gu.maze.model;


import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RoadTest {
    Road road = new Road();

    @Test
    public void testCanIMoveHere() {
        assertTrue(road.canIMoveHere() == Constants.YES);
    }

    @Test
    public void testOkayToTeleportHere() {
        assertTrue(road.okayToTeleportHere());
    }

    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        road.clearWay();
    }

    @Test
    public void testToString() {
        String R = road.toString();
        assertTrue(R.equals("R"));
    }
}
