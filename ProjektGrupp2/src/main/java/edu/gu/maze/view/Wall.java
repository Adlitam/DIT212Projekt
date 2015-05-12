package edu.gu.maze.view;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Wall extends Rectangle{

    private final int xPos;
    private final int yPos;

    public Wall(int x, int y, Paint p){
        this.xPos = x;
        this.yPos = y;
        setFill(p);    //for instance: Color.valueOf("gray")
        setHeight(30);
        setWidth(30);
    

    public int getXValue(){
        return xPos;
    }

    public int getYValue(){
        return yPos;
    }
    //@Override
    public int interact() {
        return 0;
    }

    //@Override
    public boolean teleportable() {
        return false;
    }
}
