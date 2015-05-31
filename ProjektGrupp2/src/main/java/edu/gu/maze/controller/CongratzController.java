package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.util.Constants;
import edu.gu.maze.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CongratzController implements EventHandler<ActionEvent> {
    private final Game model;
    private final Stage stage;
    private final CongratzView view;




    public CongratzController(IGame model, CongratzView view, Stage primaryStage){
        this.model = (Game) model;
        this.stage = primaryStage;
        this.view = view;
        this.view.getBackButton().setOnAction(this);
        this.view.getNextMap().setOnAction(this);
        final Label yourScore = view.getYourScore();
        yourScore.setText("Congratulations \n Your score:" + model.getPoints());
    }

    //initializes all the views and controllers needed for the actual gameplay view.
    private void play(){
        model.setGamesDoneToFalse();
        model.setStopLoops(false);
        InfoView infoView;
        InputOutputView inputView;
        infoView = new InfoView();
        InfoController infoController;
        infoController = new InfoController(model, infoView);
        inputView = new InputOutputView();
        new InputOutputViewController(model, inputView, stage);
        model.addPropertyChangeListener(inputView);
        MapView mapView;
        mapView = new MapView();
        model.addPropertyChangeListener(mapView);
        new GameView(stage, mapView, infoView, inputView);
        model.startMatch(Constants.MAP2);
        infoController.setAnimationTimer();
        new MapController(model, mapView, stage);
    }

    //handle method for when the player presses the back to start button and the next map button.
    @Override
    public void handle(ActionEvent event) {
        final Object b = event.getSource();
        if (b == view.getBackButton()) {
            model.setGamesDoneToFalse();
            final MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
        if (b == view.getNextMap()) {
            play();
        }
    }
}