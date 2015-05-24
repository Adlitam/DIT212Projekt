package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.YES;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Teleporter implements ISquare {
    @Override
    public int canIMoveHere() {
        return YES;
    }

    @Override
    public boolean okayToTeleportHere() {
        return false;
    }

    @Override
    public String toString(){
        return "Teleporter";
    }

    @Override
    public void clearWay() {
        //do nothing
    }
}
