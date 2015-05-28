package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WallView extends ImageView {

    private final int xPos;
    private final int yPos;

    public WallView(int x, int y){
        super();
        this.xPos = x;
        this.yPos = y;
        final Image image = new Image("wall2.jpg");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    @Override
    public String toString(){
        return "WallView, xPos = " + xPos + " yPos = " + yPos;
    }
}