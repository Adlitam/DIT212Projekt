package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.APPLE;
import static edu.gu.maze.util.Constants.YES;

/**
 * Created by Matildaandersson on 15-04-01.
 */
class Monster implements ISquare {
    private boolean isHungry=true;

    @Override
    public int canIMoveHere() {
        if (isHungry) return APPLE;
        else return YES;
    }

    @Override
    public boolean okayToTeleportHere() {
        return !isHungry;
    }

    public String toString(){
        return "Monster";
    }

    @Override
    public void clearWay() {
        isHungry=false;
    }

    @Override
    public void reset() {
        isHungry = true;
    }
}
