package edu.gu.maze.model;


import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RoadTest {
    Road road = new Road();

    @Test
    public void testCanIMoveHere() {
        boolean bool = road.canIMoveHere() == Constants.YES;
        assertTrue(bool);
    }


    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        road.clearWay();
    }

    @Test
    public void testToString() {
        String R = road.toString();
        boolean bool = R.equals("R");
        assertTrue(bool);
    }
}
