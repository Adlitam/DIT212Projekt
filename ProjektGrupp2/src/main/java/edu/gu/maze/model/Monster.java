package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.APPLE;
import static edu.gu.maze.util.Constants.YES;

public class Monster implements ISquare {
    private boolean isHungry=true;

    @Override
    public int canIMoveHere() {
        if (isHungry) return APPLE;
        else return YES;
    }

    @Override
    public String toString(){
        return "Monster";
    }

    @Override
    public void clearWay() {
        isHungry=false;
    }
}
