package edu.gu.maze.model;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    
    //We are not going to use equals anyway.
    @SuppressFBWarnings("EQ_COMPARETO_USE_OBJECT_EQUALS")
    @Override
    public int compareTo(HighScore h){
        if (score>h.score) {
            return -1;
        }
        if (score<h.score) {
            return 1;
        }
        final int i = date.compareTo(h.date);
        
        return i<0 ? 1:-1;
    }
    
    public int getScore(){
        return score;
    }
    
    @Override
    public String toString(){
        final SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
        return score + "\t" + name + "\t" + f.format(date);
    }
}
