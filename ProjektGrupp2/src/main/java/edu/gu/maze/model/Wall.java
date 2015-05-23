package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.NO;

/**
 *
 * @author omega
 */
class Wall implements ISquare{

    @Override
    public int canIMoveHere() {
        return NO;
    }

    @Override
    public boolean okayToTeleportHere() {
        return false;
    }
    
    public String toString(){
        return "W";
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
