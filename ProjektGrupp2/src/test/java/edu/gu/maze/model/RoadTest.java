package edu.gu.maze.model;


import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoadTest {
    Road road = new Road();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.YES,road.canIMoveHere());
    }


    // Test if no errors occurs when calling ClearWay()
    @Test
    public void testClearWay() {
        road.clearWay();
    }

    @Test
    public void testToString() {
        String R = road.toString();
        assertEquals("R",R);
    }
}
