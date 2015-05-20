package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MainController implements PropertyChangeListener {
    Game model;
    Stage stage;

    public MainController(IGame model, Stage primaryStage){
        this.stage = primaryStage;
        this.model = (Game) model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case "highScoreButton":
                HighScoreView highScoreView = new HighScoreView(stage);
                HighScoreController highScoreController = new HighScoreController(model, stage);
                highScoreView.addPropertyChangeListener(highScoreController);
            break;
            case "Play":
                StartView startView = new StartView(stage);
                StartController startController = new StartController(model, stage);
                startView.addPropertyChangeListener(startController);
            break;
            case "aboutbutton":
                AboutView aboutView = new AboutView(stage);
                AboutController aboutController = new AboutController(model, stage);
                aboutView.addPropertyChangeListener(aboutController);
                break;
        }

    }
}
