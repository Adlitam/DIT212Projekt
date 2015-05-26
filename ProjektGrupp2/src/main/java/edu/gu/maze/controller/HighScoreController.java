package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.HighScoreView;
import edu.gu.maze.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HighScoreController implements EventHandler<ActionEvent> {
    private IGame model;
    private Stage stage;
    private HighScoreView view;

    public HighScoreController(IGame model, HighScoreView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addController(this);
    }

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
    }
}
