package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
class Monster implements ISquare {
    //private boolean isHungry=true;

    @Override
    public int interact() {
        return 0;
    }

    @Override
    public boolean teleportable() {
        return false;
    }
}
