package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MonsterTest {
    Monster monster = new Monster();

    @Test
    public void testCanIMoveHere() {
        boolean bool = monster.canIMoveHere() == Constants.APPLE;
        assertTrue(bool);
    }

    // Test if the Monster is not hungry after calling ClearWay()
    @Test
    public void testClearWay() {
        monster.clearWay();
        boolean bool =monster.canIMoveHere() == Constants.YES;
        assertTrue(bool);
    }

    @Test
    public void testToString() {
        String M = monster.toString();
        boolean bool = M.equals("Monster");
        assertTrue(bool);
    }

}
