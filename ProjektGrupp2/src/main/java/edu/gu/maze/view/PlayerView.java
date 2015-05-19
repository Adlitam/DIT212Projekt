package edu.gu.maze.view;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class PlayerView extends ImageView{
    private int xPos;
    private int yPos;
    private Image image = new Image("thief.png");
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public PlayerView(int x, int y){
        xPos = x;
        yPos = y;
        setImage(image);
        setFitWidth(30);
        setFitHeight(30);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void update(int x, int y){
        xPos = x;
        yPos = y;
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
}
