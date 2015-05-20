package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by xiang-yu on 2015-05-20.
 */
public class FinalDoorView extends ImageView{
    private final int xPos;
    private final int yPos;
    private Image image;

    public FinalDoorView(int x, int y){
        this.xPos = x;
        this.yPos = y;
        image = new Image("road.jpg");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    public int getXValue(){
        return xPos;
    }

    public int getYValue(){
        return yPos;
    }

    @Override
    public String toString(){
        return "FinalDoorView, xPos = " + xPos + " yPos = " + yPos;
    }
}
