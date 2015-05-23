package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.YES;

/**
 *
 * @author omega
 */
class Road implements ISquare{

    @Override
    public int canIMoveHere() {
        return YES;
    }

    @Override
    public boolean okayToTeleportHere() {
        return true;
    }

    public String toString(){
        return "R";
    }

    @Override
    public void clearWay() {
        //do nothing
    }

    @Override
    public void reset() {
        //do nothing
    }
}
