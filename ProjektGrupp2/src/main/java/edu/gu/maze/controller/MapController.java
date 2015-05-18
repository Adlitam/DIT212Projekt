package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InputOutputView;
import edu.gu.maze.view.MapView1;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MapController implements PropertyChangeListener{
    IGame model;
    MapView1 view;
    InputOutputView inputView;
    Stage stage;

    public MapController(IGame model, MapView1 view, InputOutputView inputView, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.inputView = inputView;
        this.inputView.addPropertyChangeListener(this);
        this.view.addPropertyChangeListener(this);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "UP":
                System.out.println("Key Pressed: UP");
                view.movePlayer(11,14);
                break;
            case "DOWN":
                System.out.println("Key Pressed: DOWN");
                //model.moveDown();
                break;
            case "LEFT":
                System.out.println("Key Pressed: LEFT");
                //model.moveLeft();
                break;
            case "RIGHT":
                System.out.println("Key Pressed: RIGHT");
                //model.moveRight();
                break;
        }
    }
}
