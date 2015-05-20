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
    private int x;
    private int y;
    
    public Map (String filename, int x, int y) throws FileNotFoundException{
        Scanner s = new Scanner(new File(filename));
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
        System.out.println("Y" + y);
    }
    
    public void moveDown(){
        y++;
        System.out.println("Y" + y);
    }
    public void moveRight(){
        x++;
        System.out.println("X" + x);
    }
    public void moveLeft(){
        x--;
        System.out.println("X" + x);
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
