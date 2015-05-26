package edu.gu.maze.controller;

import edu.gu.maze.util.Constants;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Created by Matildaandersson on 15-05-19.
 */
public class StartController implements EventHandler<ActionEvent> {
    private IGame model;
    private Game map;
    private Stage stage;
    private StartView view;
    private Constants cons = new Constants();

    public StartController(IGame model, StartView view, Stage primaryStage){
        this.map = (Game) model;
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addController(this);
    }

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getSlot1Button()){
            CreatePlayerView startView1 = new CreatePlayerView(stage, cons.SLOT1);
            CreatePlayerController createPlayerController1 = new CreatePlayerController(model, startView1, stage);
        }
        if(b == view.getSlot2Button()){
            CreatePlayerView startView2 = new CreatePlayerView(stage, cons.SLOT2);
            CreatePlayerController createPlayerController2 = new CreatePlayerController(model, startView2, stage);
        }
        if(b == view.getSlot3Button()){
            CreatePlayerView startView3 = new CreatePlayerView(stage, cons.SLOT3);
            CreatePlayerController createPlayerController3 = new CreatePlayerController(model, startView3, stage);
        }
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            MainController mainController = new MainController(model, mainView, stage);
        }
    }
}