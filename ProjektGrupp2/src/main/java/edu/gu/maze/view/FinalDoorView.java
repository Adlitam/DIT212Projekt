package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FinalDoorView extends ImageView{
    private final int xPos;
    private final int yPos;

    public FinalDoorView(int x, int y){
        super();
        this.xPos = x;
        this.yPos = y;
        final Image image = new Image("FinalDoor.png");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    @Override
    public String toString(){
        return "FinalDoorView, xPos = " + xPos + " yPos = " + yPos;
    }
}