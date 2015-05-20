package edu.gu.maze.model;

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
class Map implements Serializable{
    ISquare[][] map;
    ArrayList<HighScore> scores = new ArrayList();
    private int x = 14;
    private int y = 11;
    
    public Map (String filename) throws FileNotFoundException{
        Scanner s = null;
        s = new Scanner(new File(filename));
        ArrayList<ISquare[]> list = new ArrayList();
        while(s.hasNext()){
            ArrayList<ISquare> snd = new ArrayList();
            for (char c : s.next().toCharArray()){
                if (c=='W'){
                snd.add(new Wall());
                        }
                if (c=='F')snd.add(new FinalDoor());
                else snd.add(new Road());
            }
            list.add(snd.toArray(new ISquare[1]));
        }
        map = list.toArray(new ISquare[1][1]);
        
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
    
    public int tryMoveUp(){
        return map[y-1][x].canIMoveHere();
    }
    
   public int tryMoveDown(){
        return map[y+1][x].canIMoveHere();
    }
    
   public int tryMoveLeft(){
        return map[y][x-1].canIMoveHere();
    }
    
    public int tryMoveRight(){
        return map[y][x+1].canIMoveHere();
    }
    
    public void moveUp(){
        y--;
    }
    
    public void moveDown(){
        y++;
    }
    public void moveRight(){
        x++;
    }
    public void moveLeft(){
        x--;
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
