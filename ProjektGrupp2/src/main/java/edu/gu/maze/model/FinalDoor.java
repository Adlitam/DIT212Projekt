package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.FINAL;

/**
 *
 * @author omega
 */
public class FinalDoor implements ISquare{

    @Override
    public int canIMoveHere() {
        return FINAL;
    }

    @Override
    public boolean okayToTeleportHere() {
        return false;
    }

    //this method should not be implemented since it's violating interface segregation principle but I don't know how to fix it.
    @Override
    public void clearWay() {
        //do nothing
    }

    @Override
    public String toString(){
        return "F";
    }
}
