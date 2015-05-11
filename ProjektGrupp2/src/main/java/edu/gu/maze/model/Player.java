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
    public Player (String name, int type){
        this.name = name;
        this.type = type;
    }
}
