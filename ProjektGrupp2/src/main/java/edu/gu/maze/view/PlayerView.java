package edu.gu.maze.view;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class PlayerView extends ImageView{
    private int xPos;
    private int yPos;

    public PlayerView(int x, int y, int type){
        xPos = x;
        yPos = y;
        Image image = null;
        switch(type){
            case 0:
                image = new Image("warrior.png");
                break;
            case 1:
                image = new Image("Mage.png");
                break;
            case 2:
                image = new Image("thief.png");
                break;
            default:
                System.out.println("Arrggh! something went wrong when " +
                        "initializing playerView. Type should be 0, 1 or 2, " +
                        "but is: " + type);
        }
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    public void update(int x, int y){
        xPos = x;
        yPos = y;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}