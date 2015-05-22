package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InfoController implements PropertyChangeListener{
    IGame model;
    Stage stage;
    private int a;
    private int b;


    public InfoController(IGame model, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "timer":
                // Displays the time in minutes and seconds
                Label time = (Label) evt.getOldValue();
                int sec = ((a++) / 60) % 60;
                int min = ((b++) / 3600) % 60;
                time.setText(String.format("%02d:%02d", min, sec));
                break;
            case "apples":
                // calls the method getApples() in IGame 60 times/sec and updated the view
                Label apple = (Label) evt.getOldValue();
                apple.setText(model.getApples().toString());
                break;
            case "keys":
                // calls the method getKeys() in IGame 60 times/sec and updated the view
                Label keys = (Label) evt.getOldValue();
                keys.setText(model.getKeys().toString());
                break;
            case "points":
                // calls the method getPoints() in IGame 60 times/sec and updated the view
                Label points = (Label) evt.getOldValue();
                points.setText(model.getPoints().toString());
                break;
            default:
        }



    }
}
