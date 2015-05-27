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

    //this method should not be implemented since it's violating interface segregation principle but I don't know how to fix it.
    @Override
    public void clearWay() {
        //do nothing
    }

    @Override
    public String toString(){
        return "Teleporter";
    }
}
