package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public interface ISquare {

    public abstract int canIMoveHere();

    public abstract boolean okayToTeleportHere();

    @Override
    public String toString();
}
