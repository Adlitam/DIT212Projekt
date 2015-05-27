package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 *
 * @author omega
 */
public class Match{
    private final ISquare[][] map;
    
    private int x;
    private int y;
    private int apples;
    private int keys;
    private boolean finalkey = false;
    private int score = 0;
    private int time = 0;
    
    @SuppressFBWarnings("EI_EXPOSE_REP2")
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

        // If you have any apple you give the apple and say that you can move here
        // else it says that you can not move here
        if (permission == Constants.APPLE){
            if (apples>0) {
                apples--;
                
                map[y][x].clearWay();
                return Constants.GOTAPPLE;
            }
            else{
                score -= 5;
                if(score<=-5000){
                    score = 1000000;
                    apples = 1000000;
                    keys = 1000000;
                    System.out.println("The Game glitched :p ");
                }
                return Constants.APPLE;
            }
        }

        // If you have any key you usa a key and say that you can move here
        // else it says that you can not move here
        else if (permission == Constants.KEY){
            if (keys>0) {
                keys--;
                
                map[y][x].clearWay();
                return Constants.GOTKEY;
            }
            else return Constants.KEY;
        }

        else if (permission == Constants.CHEST){
            keys++;
            apples++;
            score += 10;
            map[y][x].clearWay();
        return Constants.CHEST;
        }

        // If you have the final key you use the final and say that you can move here
        // else it says that you can not move here
        else if (permission == Constants.FINAL){
            if (finalkey) {
                
                return Constants.FINAL;
            }
            else return Constants.NOFINAL;
        }

        // Tells you that you met a Questioner and do nothing else
        else if (permission == Constants.QUESTIONER){
            return Constants.QUESTIONER;
        }
        else if (permission == Constants.YES){
            
        map[y][x].clearWay();
        return Constants.YES;}
        
        else if (permission == Constants.GOTAPPLE){
            apples++;
            map[y][x].clearWay();
            return Constants.GOTAPPLE;
        }
        else if (permission == Constants.GOTKEY){
            keys++;
            map[y][x].clearWay();
            return Constants.GOTKEY;
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

    protected void wrongAnswer(){
        score-=5;
    }
    
    
    @Override
    public String toString(){
        StringBuilder buf = new StringBuilder();
        for (ISquare[] i : map){
            for (ISquare s : i){
                buf.append(s.toString());
            }
            buf.append("\n");
        }
        return buf.toString();
    }
    
    protected void setTime(int min, int sec){
        time=min*60+sec;
    }
    
    protected void endMatch(){
        score += Math.max(0, 500-time);
    }
}
