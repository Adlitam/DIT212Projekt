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
    private int x;
    private int y;
    int[] scores = new int[3];
    private int totalHighScore = 0;

    public Player (String name, int type){
        this.name = name;
        this.type = type;
    }

    public Player(String name, int type, int x, int y){
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
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
