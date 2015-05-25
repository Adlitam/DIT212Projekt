package edu.gu.maze.model;
import java.io.Serializable;
/**
 *
 * @author omega
 */
public class SaveSlot implements Serializable{
    private static final long serialVersionUID = 3L;
    final String name;
    final int type;
    
    int[] scores = new int[3];
    private int totalHighScore = 0;

    public SaveSlot (String name, int type){
        this.name = name;
        this.type = type;
    }

    public int getTotalHighScore() {
        return totalHighScore;
    }

    
    //Updates Player's total score, if necessary, and returns a new HighScore object
    //for the player.
    protected HighScore addHighScore(int score, int map){
        if (scores[map]<score) {
            totalHighScore-=scores[map];
            totalHighScore +=score;
            scores[map]=score;
        }
        return new HighScore(name, totalHighScore);
    }
    
}
