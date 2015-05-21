package edu.gu.maze.view;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class PlayerView extends ImageView{
    private int xPos;
    private int yPos;

    public PlayerView(int x, int y){
        xPos = x;
        yPos = y;
        Image image = new Image("warrior.png");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    public void update(int x, int y){
        xPos = x;
        yPos = y;
    }
/* TODO
    public void setxPos(int x){
        xPos = x;
    }

    public void setyPos(int y){
        yPos = y;
    }
*/
    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }
}