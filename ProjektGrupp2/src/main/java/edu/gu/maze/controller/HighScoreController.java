package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.HighScoreView;
import edu.gu.maze.view.MainView;
import edu.gu.maze.view.TotalScoreView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HighScoreController implements EventHandler<ActionEvent> {
    private final IGame model;
    private Stage stage;
    private final HighScoreView view;
    private String[] score;

    public HighScoreController(IGame model, HighScoreView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.getBackButton().setOnAction(this);
        this.view.getTotalScoreButton().setOnAction(this);
    }

    //handle method for when the player presses the back to start button and total score Button.
    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }else if(b == view.getTotalScoreButton()){
            score = model.getTotalHighScores();
            TotalScoreView totalScore = new TotalScoreView(stage,score);
            new TotalScoreController(model,totalScore,stage);

        }
    }
}