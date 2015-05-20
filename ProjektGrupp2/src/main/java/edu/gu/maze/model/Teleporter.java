package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
class Teleporter implements ISquare {
    @Override
    public int canIMoveHere() {
        return 0;
    }

    @Override
    public boolean okayToTeleportHere() {
        return false;
    }

    public String toString(){
        return "Teleporter";
    }
}
