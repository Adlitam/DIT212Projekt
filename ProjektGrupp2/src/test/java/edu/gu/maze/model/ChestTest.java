package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChestTest {
   final private Chest chest = new Chest();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.CHEST,chest.canIMoveHere());
    }

    // Test if the Chest is open after calling ClearWay()
    @Test
    public void testClearWay() {
        chest.clearWay();
        assertEquals(Constants.YES,chest.canIMoveHere());
    }

    @Test
    public void testToString() {
        final String C = chest.toString();
        assertEquals("Chest",C);
    }


}
