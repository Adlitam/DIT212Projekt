package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class MainController implements EventHandler<ActionEvent> {
    private Game model;
    private Stage stage;
    private MainView view;

    public MainController(IGame model, MainView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = (Game) model;
        this.view = view;
        this.view.addController(this);
    }

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getHighScoreButton()){
            HighScoreView highScoreView = new HighScoreView(stage);
            HighScoreController highScoreController = new HighScoreController(model, highScoreView, stage);
        }
        if(b == view.getPlayButton()){
            StartView startView = new StartView(stage);
            StartController startController = new StartController(model, startView, stage);
        }
        if(b == view.getAboutButton()){
            AboutView aboutView = new AboutView(stage);
            AboutController aboutController = new AboutController(model, aboutView, stage);
        }
    }
}