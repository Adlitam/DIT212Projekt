package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MainView;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class HighScoreController implements PropertyChangeListener {
    IGame model;
    Stage stage;

    public HighScoreController(IGame model, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("backButtonH")){
            MainView mainView = new MainView(stage);
            MainController mainController = new MainController(model, stage);
            mainView.addPropertyChangeListener(mainController);
        }
    }
}
