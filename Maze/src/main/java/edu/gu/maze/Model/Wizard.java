package edu.gu.maze.Model;

import edu.gu.maze.Model.ISquare;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Wizard implements ISquare {
    @Override
    public int interact() {
        return 0;
    }

    @Override
    public boolean teleportable() {
        
        return false;
    }
}
