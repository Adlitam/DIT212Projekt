package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.HighScoreView;
import edu.gu.maze.view.MainView;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class HighScoreController implements PropertyChangeListener {
    IGame model;
    HighScoreView view;
    Stage stage;

    public HighScoreController(IGame model, HighScoreView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "backButtonH"){
            MainView mainView = new MainView(stage);
            MainController h = new MainController(model, mainView, stage);
        }
    }
}
