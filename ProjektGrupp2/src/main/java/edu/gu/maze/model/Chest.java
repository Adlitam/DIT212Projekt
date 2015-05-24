package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.GOTKEY;
import static edu.gu.maze.util.Constants.YES;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Chest implements ISquare {
    //TODO: add constructor which distributes apples and keys randomly
    int contains = GOTKEY;
    @Override
    public int canIMoveHere() {
        return contains;
    }

    @Override
    public boolean okayToTeleportHere() {

        return true;
    }

    @Override
    public String toString(){
        return "Chest";
    }

    @Override
    public void clearWay() {
        contains = YES;
    }
}
