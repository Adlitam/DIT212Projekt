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
}
