/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.FINAL;

/**
 *
 * @author omega
 */
public class FinalDoor implements ISquare{

    @Override
    public int canIMoveHere() {
        return FINAL;
    }

    @Override
    public boolean okayToTeleportHere() {
        return false;
    }

    public String toString(){
        return "F";
    }

    @Override
    public void clearWay() {
        //do nothing
    }

    @Override
    public void reset() {
        //do nothing
    }
}
