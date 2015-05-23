package edu.gu.maze.model;
import edu.gu.maze.util.Constants;
import java.io.Serializable;
/**
 *
 * @author omega
 */
class SaveSlot implements Serializable{
    private static final long serialVersionUID = 3L;
    final String name;
    final int type;
    
    int[] scores = new int[3];
    private int totalHighScore = 0;

    public SaveSlot (String name, int type){
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
