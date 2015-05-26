package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public interface ISquare {

    public abstract int canIMoveHere();

    public abstract boolean okayToTeleportHere();
    
    public abstract void clearWay();

    @Override
    public String toString();
}
