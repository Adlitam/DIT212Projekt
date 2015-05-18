package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Created by Matildaandersson on 15-04-01.
 */
public class RoadView extends ImageView{
    private final int xPos;
    private final int yPos;
    Image image = new Image("road.jpg");

    public RoadView(int x, int y){
        this.xPos = x;
        this.yPos = y;
        //setFill(p);    //for instance: Color.valueOf("gray")
        //setHeight(50);
        //setWidth(50);
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

    //@Override
    public int interact() {
        return 0;
    }

    //@Override
    public boolean teleportable() {
        return true;
    }
}
