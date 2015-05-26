package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ChestView extends ImageView {
    private final int xPos;
    private final int yPos;

    public ChestView(int x, int y){
        this.xPos = x;
        this.yPos = y;
        Image image = new Image("Chest.png");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    @Override
    public String toString(){
        return "ChestView, xPos = " + xPos + " yPos = " + yPos;
    }
}
