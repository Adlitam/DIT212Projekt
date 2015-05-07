package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MainView;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MainController implements Observer {
    IGame model;
    MainView view;

    public MainController(IGame model, MainView view){
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o == view){
            if(view.getPlayButtonPressed()){
                view.setPlayButtonFalse();
                view.changeToGameScene();
            }
            if(view.getBackButtonPressed()){
                view.setBackButtonFalse();
                view.changeToStartScene();
            }
            if(view.getHighScoreButtonPressed()){
                view.setHighScoreButtonFalse();
                view.changeToHighScoreScene();
            }
        }

    }
}
