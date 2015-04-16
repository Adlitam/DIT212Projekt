package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Monster implements ISquare {
    boolean isHungry;

    private boolean getisHungry(){
        return isHungry;
    }

    private void setisHungry(boolean hungry){
        isHungry=hungry;
    }

    @Override
    public int interact() {
        return 0;
    }

    @Override
    public boolean teleportable() {
        return false;
    }
}
