package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.KEY;
import static edu.gu.maze.util.Constants.YES;

public class Door implements ISquare {
    private boolean open;
    @Override
    public int canIMoveHere() {
        return open ? YES:KEY;
    }

    @Override
    public void clearWay() {
        open=true;
    }
}
