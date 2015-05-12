package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MainController implements PropertyChangeListener {
    IGame model;
    MainView view;
    Stage stage;
    Player player;

    public MainController(IGame model, MainView view, Stage primaryStage, Player player){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.player = player;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("playButton")){
            MapView1 mapView1 = new MapView1(player);
            new MapController(model, mapView1, stage, player);
            InfoView infoView = new InfoView();
            new InfoController(model, infoView, stage);
            InputOutputView inputView = new InputOutputView();
            new InputOutputController(model, inputView, stage, player);
            new GameView(stage, mapView1, infoView, inputView);

        }
        if(evt.getPropertyName().equals("highScoreButton")){
            HighScoreView highScoreView = new HighScoreView(stage);
            new HighScoreController(model, highScoreView, stage, player);
        }
    }
}
