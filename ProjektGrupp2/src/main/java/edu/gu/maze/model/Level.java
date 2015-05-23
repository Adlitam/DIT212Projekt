package edu.gu.maze.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author omega
 */
public class Level implements Serializable{
    private ArrayList<HighScore> scores = new ArrayList();
    private String map;
    private int startX;
    private int startY;
    
    public Level (String map, int x, int y){
        this.map = map;
        startX = x;
        startY = y;
    }

    public String getMap() {
        return map;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
    
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
