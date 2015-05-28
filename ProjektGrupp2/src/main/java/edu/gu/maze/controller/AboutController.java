package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.AboutView;
import edu.gu.maze.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class AboutController implements EventHandler<ActionEvent> {
    private Game model;
    private Stage stage;
    private AboutView view;

    public AboutController(IGame model, AboutView view, Stage primaryStage){
        this.model = (Game) model;
        this.stage = primaryStage;
        this.view = view;
        this.view.getBackButton().setOnAction(this);
    }

    //handle method for when the player presses the back to start button.
    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
    }
}