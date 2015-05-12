package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.HighScoreView;
import edu.gu.maze.view.MainView;
import edu.gu.maze.view.Player;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class HighScoreController implements PropertyChangeListener {
    IGame model;
    HighScoreView view;
    Stage stage;
    Player player;

    public HighScoreController(IGame model, HighScoreView view, Stage primaryStage, Player player){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.player = player;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("backButtonH")){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage, player);
        }
    }
}
