package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InfoController implements PropertyChangeListener{
    IGame model;
    Stage stage;
    private int sec;
    private int min;

    public InfoController(IGame model, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "timer":
                Label time = (Label) evt.getOldValue();
                time.setText((min++/3600)%60 + ":" + (sec++/60)%60);
                break;
        }



    }
}
