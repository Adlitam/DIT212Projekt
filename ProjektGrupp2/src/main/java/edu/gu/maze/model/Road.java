package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.YES;

/**
 *
 * @author omega
 */
public class Road implements ISquare{

    @Override
    public int canIMoveHere() {
        return YES;
    }

    @Override
    public boolean okayToTeleportHere() {
        return true;
    }

    @Override
    public String toString(){
        return "R";
    }
}
