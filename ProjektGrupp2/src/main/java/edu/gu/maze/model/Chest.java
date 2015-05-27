package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.*;

public class Chest implements ISquare {
    private boolean open = false;
    @Override
    public int canIMoveHere() {
        if (open) return YES;
        else return CHEST;
    }

    @Override
    public String toString(){
        return "Chest";
    }

    @Override
    public void clearWay() {
        open=true;
    }
}
