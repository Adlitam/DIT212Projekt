package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TeleporterView extends ImageView {
    private final int xPos;
    private final int yPos;

    public TeleporterView(int x, int y){
        this.xPos = x;
        this.yPos = y;
        Image image = new Image("Teleporter.png");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    @Override
    public String toString(){
        return "TeleporterView, xPos = " + xPos + " yPos = " + yPos;
    }
}