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
        System.out.print(player + "\n");
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "playButton"){
            MapView1 mapView1 = new MapView1(stage,player);

            MapController mapController = new MapController(model, mapView1, stage, player);

            InfoView infoView = new InfoView();
            InfoController infoController = new InfoController(model, infoView, stage);
            InputView inputView = new InputView();
            InputController inputController = new InputController(model, inputView, stage, player);
            OutputView outputView = new OutputView();
            OutputController outputController = new OutputController(model, outputView, stage);

            GameView gameView = new GameView(stage, mapView1, infoView, inputView, outputView);


        }
        if(evt.getPropertyName() == "highScoreButton"){
            HighScoreView highScoreView = new HighScoreView(stage);
            HighScoreController h = new HighScoreController(model, highScoreView, stage, player);
        }
    }
}
