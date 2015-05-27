package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DoorTest {

    Door door = new Door();

    @Test
    public void testCanIMoveHere() {
        boolean bool = door.canIMoveHere() == Constants.KEY;
        assertTrue(bool);
    }

    // Test if the door is open after calling ClearWay()
    @Test
    public void testClearWay() {
        door.clearWay();
        boolean bool = door.canIMoveHere() == Constants.YES;
        assertTrue(bool);
    }

    @Test
    public void testToString() {
        String D = door.toString();
        boolean bool = D.equals("Door");
        assertTrue(bool);
    }
}
