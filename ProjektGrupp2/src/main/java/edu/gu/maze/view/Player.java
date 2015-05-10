package edu.gu.maze.view;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Player extends ImageView{
    private String playerName = "john";
    private int xPos;
    private int yPos;
    private Image image = new Image("player1.png");

    public Player(){
    }

    public Player(int x, int y){
        xPos = x;
        yPos = y;
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }


    public void update(int x, int y){
        xPos = x;
        yPos = y;
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);

    }



    public void setxPos(int x){
        xPos = x;
    }

    public void setyPos(int y){
        yPos = y;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    private String getplayerName(){
        return playerName;
    }

    private void setplayerName(String name){
        playerName=name;
    }

}
