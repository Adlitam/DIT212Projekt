package edu.gu.maze.controller;

import edu.gu.maze.model.Constants;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Matildaandersson on 15-05-19.
 */
public class StartController implements PropertyChangeListener {

    IGame model;
    Game Map;
    Stage stage;
    Constants cons = new Constants();

    public StartController(IGame model, Stage primaryStage){
        this.Map = (Game) model;
        this.stage = primaryStage;
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        switch (evt.getPropertyName()) {
            case "backButtonH":
                MainView mainView = new MainView(stage);
                MainController mainController = new MainController(model, stage);
                mainView.addPropertyChangeListener(mainController);
                break;
            case "Slot1":
                CreatePlayerView startView = new CreatePlayerView(stage,cons.SLOT1);
                CreatePlayerController createPlayerController1 = new CreatePlayerController(model, stage);
                startView.addPropertyChangeListener(createPlayerController1);
                break;
            case "Slot2":
                CreatePlayerView startView2 = new CreatePlayerView(stage,cons.SLOT2);
                CreatePlayerController createPlayerController2 = new CreatePlayerController(model, stage);
                startView2.addPropertyChangeListener(createPlayerController2);
                break;
            case "Slot3":
                CreatePlayerView startView3 = new CreatePlayerView(stage,cons.SLOT3);
                CreatePlayerController createPlayerController3 = new CreatePlayerController(model, stage);
                startView3.addPropertyChangeListener(createPlayerController3);
                break;

    }
    }
}
