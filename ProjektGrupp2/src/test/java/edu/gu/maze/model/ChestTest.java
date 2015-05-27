package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChestTest {
    Chest chest = new Chest();

    @Test
    public void testCanIMoveHere() {
        assertTrue(chest.canIMoveHere() == Constants.CHEST);
    }

    // Test if the Chest is open after calling ClearWay()
    @Test
    public void testClearWay() {
        chest.clearWay();
        assertTrue(chest.canIMoveHere() == Constants.YES);
    }

    @Test
    public void testToString() {
        String C = chest.toString();
        assertTrue(C.equals("Chest"));
    }


}
