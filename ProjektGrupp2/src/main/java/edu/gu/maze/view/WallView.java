package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class WallView extends ImageView {

    private final int xPos;
    private final int yPos;

    public WallView(int x, int y){
        this.xPos = x;
        this.yPos = y;
        Image image = new Image("wall.jpg");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }
/* TODO
    public int getXValue(){
        return xPos;
    }

    public int getYValue(){
        return yPos;
    }
*/
    @Override
    public String toString(){
        return "WallView, xPos = " + xPos + " yPos = " + yPos;
    }
}
