package edu.gu.maze.controller;


import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.AboutView;

import edu.gu.maze.view.MainView;

import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Matildaandersson on 15-05-20.
 */
public class AboutController implements PropertyChangeListener {


    IGame model;
    Game Map;
    AboutView view;
    Stage stage;


    public AboutController(IGame model, AboutView view, Stage primaryStage){
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
                MainController mainController = new MainController(model, stage);
                mainView.addPropertyChangeListener(mainController);
                break;

        }
    }

}
