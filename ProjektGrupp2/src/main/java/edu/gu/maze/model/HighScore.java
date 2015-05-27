package edu.gu.maze.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author omega
 */
class HighScore implements Comparable<HighScore>, Serializable{
    private static final long serialVersionUID = 7L;
    private final int score;
    private final String name;
    private final Date date;


    public HighScore (String name, int score){
        this.name = name;
        this.score = score;
        date = new Date();
    }
    
    //CompareTo returns  negative number if this object comes before the argument
    // and a positive one if this object comes after the other object.
    @Override
    public int compareTo(HighScore h){
        if (score>h.score) return -1;
        if (score<h.score) return 1;
        //i has a value less than 0 if this Date is before the Date argument; 
        //and a value greater than 0 if this Date is after the Date argument
        int i = date.compareTo(h.date);
        return -i;
    }
    
    public int getScore(){
        return score;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return score + "\t" + name + "\t" + f.format(date);
    }
}
