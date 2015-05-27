package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChestTest {
    Chest chest = new Chest();

    @Test
    public void testCanIMoveHere() {
        boolean bool = chest.canIMoveHere() == Constants.CHEST;
        assertTrue(bool);
    }

    // Test if the Chest is open after calling ClearWay()
    @Test
    public void testClearWay() {
        chest.clearWay();
        boolean bool = chest.canIMoveHere() == Constants.YES;
        assertTrue(bool);
    }

    @Test
    public void testToString() {
        String C = chest.toString();
        boolean bool = C.equals("Chest");
        assertTrue(bool);
    }


}
