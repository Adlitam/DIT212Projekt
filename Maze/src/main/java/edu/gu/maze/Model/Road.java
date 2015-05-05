package edu.gu.maze.Model;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Road extends ImageView implements ISquare {
    private final int xPos;
    private final int yPos;
    Image image = new Image("road.jpg");

    public Road(int x, int y, Paint p){
        this.xPos = x;
        this.yPos = y;
        //setFill(p);    //for instance: Color.valueOf("gray")
        //setHeight(50);
        //setWidth(50);
        setImage(image);
        setFitWidth(50);
        setFitHeight(50);
    }

    public int getXValue(){
        return xPos;
    }

    public int getYValue(){
        return yPos;
    }

    @Override
    public int interact() {
        return 0;
    }

    @Override
    public boolean teleportable() {
        return true;
    }
}