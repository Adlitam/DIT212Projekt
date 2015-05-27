package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FinalDoorTest {

    FinalDoor fDoor = new FinalDoor();

    @Test
    public void testCanIMoveHere() {
        assertTrue(fDoor.canIMoveHere() == Constants.FINAL);
    }

    // Test if no error
    @Test
    public void testClearWay() {
        fDoor.clearWay();
    }

    @Test
    public void testToString() {
        String fD = fDoor.toString();
        assertTrue(fD.equals("F"));
    }

}
