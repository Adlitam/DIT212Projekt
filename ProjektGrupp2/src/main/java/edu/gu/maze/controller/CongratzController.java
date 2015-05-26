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
    private Game model;
    private Stage stage;
    private CongratzView view;
    private InfoController infoController;

    public CongratzController(IGame model, CongratzView view, Stage primaryStage){
        this.model = (Game) model;
        this.stage = primaryStage;
        this.view = view;
        this.view.addController(this);

        Label yourScore = view.getYourScore();
        yourScore.setText("Congratulations \n Your score:" + model.getPoints());
    }

    private void play(){
        InfoView infoView = new InfoView();
        infoController = new InfoController(model, infoView);
        InputOutputView inputView = new InputOutputView();
        new InputOutputViewController(model, inputView, stage);
        MapView mapView = new MapView();
        model.addPropertyChangeListener(mapView);
        model.addPropertyChangeListener(inputView);
        new MapController(model, mapView, stage);
        new GameView(stage, mapView, infoView, inputView);
    }

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if (b == view.getBackButton()) {
            model.setGamesDoneToFalse();
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
        if (b == view.getNextMap()) {
            model.setGamesDoneToFalse();
            play();
            model.startMatch(Constants.MAP2);
            infoController.setAnimationTimer();
        }
    }
}
