package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MainController implements PropertyChangeListener {
    Game model;
    MainView view;
    Stage stage;

    public MainController(IGame model, MainView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = (Game) model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case "highScoreButton":
                HighScoreView highScoreView = new HighScoreView(stage);
                new HighScoreController(model, highScoreView, stage);
            break;
            case "createPlayerButton":
                CreatePlayerView createPlayerView = new CreatePlayerView(stage);
                new CreatePlayerController(model, createPlayerView, stage);
            break;
        }

    }
}
