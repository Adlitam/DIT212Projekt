package edu.gu.maze.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author omega
 */
class Map implements Serializable{
    ISquare[][] map;
    ArrayList<HighScore> scores = new ArrayList();
    public void addHighScore(HighScore score){
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
}
