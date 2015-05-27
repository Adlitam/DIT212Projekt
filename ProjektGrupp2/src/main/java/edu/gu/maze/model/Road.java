package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.YES;

/**
 *
 * @author omega
 */
public class Road implements ISquare{

    @Override
    public int canIMoveHere() {
        return YES;
    }

    //this method should not be implemented since it's violating interface segregation principle but I don't know how to fix it.
    @Override
    public void clearWay() {
        //do nothing
    }

    @Override
    public String toString(){
        return "R";
    }
}
