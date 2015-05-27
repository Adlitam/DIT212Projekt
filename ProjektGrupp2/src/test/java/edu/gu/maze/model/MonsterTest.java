package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MonsterTest {
    Monster monster = new Monster();

    @Test
    public void testCanIMoveHere() {
        assertTrue(monster.canIMoveHere() == Constants.APPLE);
    }

    // Test if the Monster is not hungry after calling ClearWay()
    @Test
    public void testClearWay() {
        monster.clearWay();
        assertTrue(monster.canIMoveHere() == Constants.YES);
    }

    @Test
    public void testToString() {
        String M = monster.toString();
        assertTrue(M.equals("Monster"));
    }

}
