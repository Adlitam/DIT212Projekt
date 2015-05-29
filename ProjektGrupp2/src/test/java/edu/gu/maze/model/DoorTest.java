package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoorTest {

    final Door door = new Door();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.KEY,door.canIMoveHere());
    }

    // Test if the door is open after calling ClearWay()
    @Test
    public void testClearWay() {
        door.clearWay();
        assertEquals(Constants.YES,door.canIMoveHere());
    }
}
