package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DoorTest {

    Door door = new Door();

    @Test
    public void testCanIMoveHere() {
        assertTrue(door.canIMoveHere() == Constants.KEY);
    }

    // Test if the door is open after calling ClearWay()
    @Test
    public void testClearWay() {
        door.clearWay();
        assertTrue(door.canIMoveHere() == Constants.YES);
    }

    @Test
    public void testToString() {
        String D = door.toString();
        assertTrue(D.equals("Door"));
    }
}
