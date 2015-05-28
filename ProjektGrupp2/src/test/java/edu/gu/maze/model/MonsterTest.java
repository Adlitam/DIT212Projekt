package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MonsterTest {
    Monster monster = new Monster();

    @Test
    public void testCanIMoveHere() {
        assertEquals(Constants.APPLE,monster.canIMoveHere());
    }

    // Test if the Monster is not hungry after calling ClearWay()
    @Test
    public void testClearWay() {
        monster.clearWay();
        assertEquals(Constants.YES,monster.canIMoveHere());
    }

    @Test
    public void testToString() {
        String M = monster.toString();
        assertEquals("Monster",M);
    }

}
