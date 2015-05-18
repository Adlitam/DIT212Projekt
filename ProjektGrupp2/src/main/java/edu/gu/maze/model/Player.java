package edu.gu.maze.model;
import java.io.Serializable;
/**
 *
 * @author omega
 */
class Player implements Serializable{
    private static final long serialVersionUID = 3L;
    private final String name;
    private final int type;
    int[] scores = new int[3];
    private int totalHighScore = 0;
    public Player (String name, int type){
        this.name = name;
        this.type = type;
    }
    
    public HighScore addHighScore(int score, int map){
        if (scores[map]<score) {
            totalHighScore-=scores[map];
            totalHighScore +=score;
            scores[map]=score;
        }
        return new HighScore(name, totalHighScore);
    }
    
}
