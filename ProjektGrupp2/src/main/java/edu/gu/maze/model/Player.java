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
    private int apples;
    private int keys;
    private boolean finalkey = false;
    int[] scores = new int[3];
    private int totalHighScore = 0;

    public Player (String name, int type){
        this.name = name;
        this.type = type;
    }

    public Player(String name, int type, int x, int y){
        this.name = name;
        this.type = type;
    }

    public int moveUp(int permission){
        if (permission == Constants.APPLE){
            if (apples>0) {
                apples--;
       
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.KEY){
            if (keys>0) {
                keys--;
                
                return Constants.YES;
            }
            else return Constants.NO;     
        }
        else if (permission == Constants.FINALKEY){
            if (finalkey) {
                
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.YES);
        return permission;
    }
    
    public int moveDown(int permission){
        if (permission == Constants.APPLE){
            if (apples>0) {
                apples--;
                
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.KEY){
            if (keys>0) {
                keys--;
                
                return Constants.YES;
            }
            else return Constants.NO;     
        }
        else if (permission == Constants.FINALKEY){
            if (finalkey) {
                
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.YES) ;
        return permission;
    }
    
    public int moveRight(int permission){
        if (permission == Constants.APPLE){
            if (apples>0) {
                apples--;
                
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.KEY){
            if (keys>0) {
                keys--;
                
                return Constants.YES;
            }
            else return Constants.NO;     
        }
        else if (permission == Constants.FINALKEY){
            if (finalkey) {
               
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.YES);
        return permission;
    }
    
    public int moveLeft(int permission){
        if (permission == Constants.APPLE){
            if (apples>0) {
                apples--;
                
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.KEY){
            if (keys>0) {
                keys--;
               
                return Constants.YES;
            }
            else return Constants.NO;     
        }
        else if (permission == Constants.FINALKEY){
            if (finalkey) {
                
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.YES);
        return permission;
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
