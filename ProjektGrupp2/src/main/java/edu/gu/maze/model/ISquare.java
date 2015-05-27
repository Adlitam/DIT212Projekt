package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public interface ISquare {

    int canIMoveHere();

    boolean okayToTeleportHere();

    @Override
    String toString();
}
