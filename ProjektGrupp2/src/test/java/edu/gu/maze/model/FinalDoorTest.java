package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinalDoorTest {

    FinalDoor fDoor = new FinalDoor();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.FINAL,fDoor.canIMoveHere());
    }

    // Test if no error
    @Test
    public void testClearWay() {
        fDoor.clearWay();
    }

    @Test
    public void testToString() {
        String fD = fDoor.toString();
        assertEquals("F",fD);
    }

}
