package edu.gu.maze.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class QuestionerView extends ImageView{
    private final int xPos;
    private final int yPos;

    public QuestionerView(int x, int y){
        this.xPos = x;
        this.yPos = y;
        Image image = new Image("Questioner.png");
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    @Override
    public String toString(){
        return "QuestionerView, xPos = " + xPos + " yPos = " + yPos;
    }
}
