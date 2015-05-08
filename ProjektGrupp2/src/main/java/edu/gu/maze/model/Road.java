package edu.gu.maze.model;

/**
 *
 * @author omega
 */
class Road implements ISquare{

    @Override
    public int canIMoveHere() {
        return 0;
    }

    @Override
    public boolean okayToTeleportHere() {
        return true;
    }
    
}
