package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.model.Map;
import edu.gu.maze.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by xiang-yu on 2015-04-28.
 */
public class GameController implements Observer {
    IGame model;
    MainView view;

    public GameController(IGame model, MainView view){
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
