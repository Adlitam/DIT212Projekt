package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FinalDoorTest {

    FinalDoor fDoor = new FinalDoor();

    @Test
    public void testCanIMoveHere() {
        boolean bool = fDoor.canIMoveHere() == Constants.FINAL;
        assertTrue(bool);
    }

    // Test if no error
    @Test
    public void testClearWay() {
        fDoor.clearWay();
    }

    @Test
    public void testToString() {
        String fD = fDoor.toString();
        boolean bool = fD.equals("F");
        assertTrue(bool);
    }

}
