package edu.gu.maze.Model;

import edu.gu.maze.Model.IGame;

import java.io.Serializable;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Game implements IGame, Serializable{
    int currentHighScore = 0;

    public int getcurrentHighScore(){
        return currentHighScore;
    }

    public void setcurrentHighScore(int score){
        currentHighScore=score;
    }
}
