package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.NO;

/**
 *
 * @author omega
 */
public class Wall implements ISquare{

    @Override
    public int canIMoveHere() {
        return NO;
    }

    @Override
    public boolean okayToTeleportHere() {
        return false;
    }
    
    @Override
    public String toString(){
        return "W";
    }
}
