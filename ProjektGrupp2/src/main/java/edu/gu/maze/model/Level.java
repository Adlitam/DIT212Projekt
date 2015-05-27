package edu.gu.maze.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author omega
*/
public class Level implements Serializable{
 /*
    private static final long serialVersionUID = 6L;
    private final ArrayList<HighScore> scores = new ArrayList<HighScore>();
    private final String map;
    public Level (String map){
        this.map = map;
    }

    public String getMap() {
        return map;
    }
    
    protected void addHighScore(HighScore score){
        scores.add(score);
        Collections.sort(scores);
        if (scores.size()>5){
            scores.remove(scores.size()-1);
        }
    }
    
    public String[] getHighScores(){
        int a = scores.size();
        String[] ans = new String[a];
        for (int i=0; i<a; i++){
            ans[i]=scores.get(i).toString();
        }
        return ans;
    }

    @Override
    public String toString(){
        return map;
    }*/
}
