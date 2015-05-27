package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.QUESTIONER;
import static edu.gu.maze.util.Constants.YES;

/**
 *
 * @author omega
 */
public class Questioner implements ISquare, ISquareSuppl{
    boolean Asked = false;

    @Override
    public int canIMoveHere() {
        if(Asked){
            return YES;
        }else{
            return QUESTIONER;
        }

    }

    @Override
    public boolean okayToTeleportHere() {
        return Asked;
    }

    @Override
    public String toString(){
        return "Questioner";
    }

    @Override
    public void clearWay() {
        Asked = true;
    }
}
