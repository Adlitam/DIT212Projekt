package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.YES;

/**
 *
 * @author omega
 */
public class Questioner implements ISquare{
    @Override
    public int canIMoveHere() {
        return YES;
    }

    @Override
    public boolean okayToTeleportHere() {
        
        return true;
    }

    public String toString(){
        return "Questioner";
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
