package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinalDoorTest {

    private final FinalDoor finalDoor = new FinalDoor();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.FINAL,finalDoor.canIMoveHere());
    }

    // Test if no error
    @Test
    public void testClearWay() {
        finalDoor.clearWay();
    }

    @Test
    public void testToString() {
        final String fD = finalDoor.toString();
        assertEquals("F",fD);
    }

}
