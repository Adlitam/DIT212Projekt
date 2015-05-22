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
                Label time = (Label) evt.getOldValue();

                int sec = ((a++) / 60) % 60;
                int min = ((b++) / 3600) % 60;

                time.setText(String.format("%02d:%02d", min, sec));

                break;
            case "apples":
                Label apple = (Label) evt.getOldValue();
                apple.setText(model.getApples().toString());
                break;
            case "keys":
                Label keys = (Label) evt.getOldValue();
                keys.setText(model.getKeys().toString());
                break;
            case "points":
                Label points = (Label) evt.getOldValue();
                points.setText(model.getPoints().toString());
                break;
            default:
        }



    }
}
