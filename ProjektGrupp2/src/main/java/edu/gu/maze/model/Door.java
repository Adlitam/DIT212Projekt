package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.KEY;
import static edu.gu.maze.util.Constants.YES;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Door implements ISquare, ISquareSuppl {
    private boolean open = false;
    @Override
    public int canIMoveHere() {
        if (open) return YES;
        else return KEY;
    }

    @Override
    public boolean okayToTeleportHere() {
        return open;
    }

    @Override
    public String toString(){
        return "Door";
    }

    @Override
    public void clearWay() {
        open=true;
    }
}
