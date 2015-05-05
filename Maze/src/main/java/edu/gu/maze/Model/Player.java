package edu.gu.maze.Model;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Player extends ImageView{
    String playerName = "john";
    private int xPos;
    private int yPos;
    Image image = new Image("player1.png");

    public Player(int x, int y){
        xPos = x;
        yPos = y;
        setImage(image);
        setFitWidth(50);
        setFitHeight(50);
    }

    public void setxPos(int x){
        xPos = x;
    }

    public void setyPos(int y){
        yPos = y;
    }


    private String getplayerName(){
        return playerName;
    }

    private void setplayerName(String name){
        playerName=name;
    }

}
