package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.util.Constants;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class StartController implements EventHandler<ActionEvent> {
    private Game model;
    private Stage stage;
    private StartView view;
    private InfoController infoController;

    public StartController(IGame model, StartView view, Stage primaryStage){
        this.model = (Game) model;
        this.stage = primaryStage;
        this.view = view;
        this.view.addController(this);
    }

    private void play(){
        InfoView infoView = new InfoView();
        infoController = new InfoController(model, infoView);
        InputOutputView inputView = new InputOutputView();
        new InputOutputViewController(model, inputView, stage);
        MapView mapView = new MapView();
        model.addPropertyChangeListener(mapView);
        new MapController(model, mapView, stage);
        new GameView(stage, mapView, infoView, inputView);
    }

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getSlot1Button()){
            if(view.checkSlot1()){
                play();
                model.startMatch(Constants.MAP1);
                infoController.setAnimationTimer();
            }else {
                CreatePlayerView createPlayerView1 = new CreatePlayerView(stage, Constants.SLOT1);
                CreatePlayerController createPlayerController1 = new CreatePlayerController(model, createPlayerView1, stage);
            }
        }
        if(b == view.getSlot2Button()){
            if(view.checkSlot2()){
                play();
                model.startMatch(Constants.MAP1);
                infoController.setAnimationTimer();
            }else {
                CreatePlayerView createPlayerView2 = new CreatePlayerView(stage, Constants.SLOT2);
                CreatePlayerController createPlayerController2 = new CreatePlayerController(model, createPlayerView2, stage);
            }
        }
        if(b == view.getSlot3Button()){
            if(view.checkSlot3()){
                play();
                model.startMatch(Constants.MAP1);
                infoController.setAnimationTimer();
            }else{
                CreatePlayerView createPlayerView3 = new CreatePlayerView(stage, Constants.SLOT3);
                CreatePlayerController createPlayerController3 = new CreatePlayerController(model, createPlayerView3, stage);
            }

        }
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            MainController mainController = new MainController(model, mainView, stage);
        }
    }
}
