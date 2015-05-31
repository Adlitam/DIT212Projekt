package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.*;

public class Chest implements ISquare {
    private boolean open;
    @Override
    public int canIMoveHere() {
        return open ? YES:CHEST;
    }

    @Override
    public void clearWay() {
        open=true;
    }
}
