package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.YES;

/**
 * Created by Matildaandersson on 15-04-01.
 */
class Chest implements ISquare {
    @Override
    public int canIMoveHere() {
        return YES;
    }

    @Override
    public boolean okayToTeleportHere() {

        return true;
    }

    public String toString(){
        return "Chest";
    }
}
