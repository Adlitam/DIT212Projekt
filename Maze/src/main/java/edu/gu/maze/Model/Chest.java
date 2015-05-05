package edu.gu.maze.Model;



/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Chest implements ISquare {
    @Override
    public int interact() {
        return 0;
    }

    @Override
    public boolean teleportable() {

        return true;
    }
}
