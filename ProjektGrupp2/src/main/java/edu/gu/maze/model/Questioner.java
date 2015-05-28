package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.QUESTIONER;

/**
 *
 * @author omega
 */
public class Questioner implements ISquare{
    @Override
    public int canIMoveHere() {
            return QUESTIONER;
    }

    //@Override
    //public String toString(){
      //  return "Questioner";
    //}

    @Override
    public void clearWay() {
        //do nothing
    }
}
