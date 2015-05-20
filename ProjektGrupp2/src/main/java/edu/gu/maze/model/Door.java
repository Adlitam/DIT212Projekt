package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
class Door implements ISquare {
    private boolean open = false;
    @Override
    public int canIMoveHere() {
        return 0;
    }

    @Override
    public boolean okayToTeleportHere() {
        return open;
    }

    public String toString(){
        return "Door";
    }
}
