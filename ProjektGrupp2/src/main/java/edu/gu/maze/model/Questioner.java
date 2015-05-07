package edu.gu.maze.model;

/**
 *
 * @author omega
 */
class Questioner implements ISquare{
    @Override
    public int interact() {
        return 0;
    }

    @Override
    public boolean teleportable() {
        
        return false;
    }
}
