package edu.gu.maze.model;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Game {
    int currentHighScore = 0;

    public int getcurrentHighScore(){
        return currentHighScore;
    }

    public void setcurrentHighScore(int score){
        currentHighScore=score;
    }
}
