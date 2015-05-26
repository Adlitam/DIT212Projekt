package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.CongratzView;
import edu.gu.maze.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CongratzController implements EventHandler<ActionEvent> {
    private Game model;
    private Stage stage;
    private CongratzView view;

    public CongratzController(IGame model, CongratzView view, Stage primaryStage){
        this.model = (Game) model;
        this.stage = primaryStage;
        this.view = view;
        this.view.addController(this);

        Label yourScore = view.getYourScore();
        yourScore.setText("Congratulations \n Your score:" + model.getPoints());
    }

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getBackButton()){
            model.setCurrentMatchToNull();
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
        if(b == view.getNextMap()){
            //TODO
        }
    }
}
