package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * Created by Johan on 2015-05-07.
 */
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
