package edu.gu.maze.model;
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
