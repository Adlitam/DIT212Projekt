package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import java.io.Serializable;

/**
 *
 * @author omega
 */
public class Match implements Serializable{
    private final ISquare[][] map;
    
    private int x;
    private int y;
    private int apples;
    private int keys;
    private boolean finalkey = false;
    private int score = 0;
    
    public Match (ISquare[][] map, int x, int y){
        this.map = map;
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getApples() {
        return apples;
    }

    public int getKeys() {
        return keys;
    }

    public boolean getFinalkey() {
        return finalkey;
    }

    public int getScore() {
        return score;
    }
    
    private int moveTo (int x, int y){
        int permission = map[y][x].canIMoveHere();
        if (permission == Constants.APPLE){
            if (apples>0) {
                apples--;
                
                map[y][x].clearWay();
                return Constants.YES;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.KEY){
            if (keys>0) {
                keys--;
                
                map[y][x].clearWay();
                return Constants.YES;
            }
            else return Constants.NO;     
        }
        else if (permission == Constants.FINAL){
            if (finalkey) {
                
                return Constants.FINAL;
            }
            else return Constants.NO;
        }
        else if (permission == Constants.YES){
            
        map[y][x].clearWay();
        return Constants.YES;}
        
        else if (permission == Constants.GOTAPPLE){
            apples++;
            map[y][x].clearWay();
            return Constants.YES;
        }
        else if (permission == Constants.GOTKEY){
            keys++;
            map[y][x].clearWay();
            return Constants.YES;
        }
        else return Constants.NO;
    }
    
    protected int moveUp(){
        int permission = moveTo(x, y-1);
        if (permission == Constants.YES) y--;
        return permission;
    }
    
    protected int moveDown(){
        int permission = moveTo(x, y+1);
        if (permission == Constants.YES) y++;
        return permission;
    }
    
    protected int moveRight(){
        int permission = moveTo(x+1, y);
        if (permission == Constants.YES) x++;
        return permission;
    }
    protected int moveLeft(){
        int permission = moveTo(x-1, y);
        if (permission == Constants.YES) x--;
        return permission;
    }
    
    protected void correctAnswer(){
        apples++;
        keys++;
        score+=5;
            finalkey =true;
    }
    
    
    @Override
    public String toString(){
        String string = "";
        for (ISquare[] i : map){
            for (ISquare s : i){
                string += s.toString();
            }
            string += "\n";
        }
        return string;
    }
}