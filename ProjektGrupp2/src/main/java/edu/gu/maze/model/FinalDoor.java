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

    @Override
    public String toString(){
        return "F";
    }

    @Override
    public void clearWay() {
        //do nothing
    }
}
