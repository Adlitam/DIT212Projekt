package edu.gu.maze.model;

import edu.gu.maze.util.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author omega
 */
class Match implements Serializable{
    private ISquare[][] map;
    
    private int x;
    private int y;
    private int startx;
    private int starty;
    private int apples;
    private int keys;
    private boolean finalkey = false;
    private int score = 0;
    
    protected Match (String filename, int x, int y){
        Scanner s;
        try {
        s = new Scanner(new File(filename));
        } catch (FileNotFoundException e){
            throw new RuntimeException ("Couldn't find file " + filename);
        }
        ArrayList<ISquare[]> list = new ArrayList();
        while(s.hasNext()){
            ArrayList<ISquare> snd = new ArrayList();
            for (char c : s.next().toCharArray()){
                if (c=='W') snd.add(new Wall());
                  
                else if (c=='F')snd.add(new FinalDoor());
                else snd.add(new Road());
            }
            list.add(snd.toArray(new ISquare[1]));
        }
        map = list.toArray(new ISquare[1][1]);
        this.x = x;
        this.y = y;
        startx=x;
        starty=y;
        
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

    public boolean isFinalkey() {
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
