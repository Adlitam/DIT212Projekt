package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InfoController implements PropertyChangeListener{
    IGame model;
    Stage stage;

    public InfoController(IGame model, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
