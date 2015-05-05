package edu.gu.maze.Controller;

import edu.gu.maze.Model.IGame;
import edu.gu.maze.View.MainView;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by xiang-yu on 2015-04-28.
 */
public class Controller implements Observer {

    edu.gu.maze.Model.IGame model;
    MainView view;

    public Controller(IGame model, MainView view){
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
