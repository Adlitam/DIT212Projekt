package edu.gu.maze.controller;

import edu.gu.maze.model.Constants;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;

import edu.gu.maze.view.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Matildaandersson on 15-05-19.
 */
public class StartController implements PropertyChangeListener {

    IGame model;
    Game Map;
    StartView view;
    Stage stage;
    Constants cons = new Constants();





    public StartController(IGame model, StartView view, Stage primaryStage){
        this.Map = (Game) model;
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        switch (evt.getPropertyName()) {
            case "backButtonH":
        MainView mainView = new MainView(stage);
        new MainController(model, mainView, stage);
        break;

            case "playButton":
        InfoView infoView = new InfoView();
        new InfoController(model, infoView, stage);
        InputOutputView inputView = new InputOutputView();
        new InputOutputController(model, inputView, stage);
        MapView1 mapView1 = new MapView1();
        Map.addPropertyChangeListener(mapView1);
        new MapController(model, mapView1, inputView, stage);
        new GameView(stage, mapView1, infoView, inputView);
        break;
            case "Slot1":
                CreatePlayerView startView = new CreatePlayerView(stage,cons.SLOT1);
                new CreatePlayerController(model, startView, stage);
                break;
            case "Slot2":
                CreatePlayerView startView2 = new CreatePlayerView(stage,cons.SLOT2);
                new CreatePlayerController(model, startView2, stage);
                break;
            case "Slot3":
                CreatePlayerView startView3 = new CreatePlayerView(stage,cons.SLOT3);
                new CreatePlayerController(model, startView3, stage);
                break;

    }
    }
}
