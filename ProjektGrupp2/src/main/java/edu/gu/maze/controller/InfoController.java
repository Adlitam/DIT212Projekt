package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InfoView;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;

public class InfoController{
    private final Game model;
    private final InfoView view;
    private int a;
    private int b;
    private AnimationTimer animationTimer;

    public InfoController(IGame model, InfoView view){
        this.model = (Game) model;
        this.view = view;
    }

    public void setAnimationTimer(){
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                // Stop the timer if the game is done
                // else shows the updated time,apple,key and score
                if(model.isTheGameDone()){
                    animationTimer.stop();
                }else {
                    // Displays the time in minutes and seconds
                    Label time = view.getTime();
                    int sec = ((a++) / 60) % 60;
                    int min = ((b++) / 3600) % 60;
                    model.setTime(min, sec);
                    time.setText(String.format("%02d:%02d", min, sec));

                    // Calls the method getApples() in IGame 60 times/sec and updated the view
                    Label apple = view.getNrApples();
                    apple.setText(model.getApples().toString());

                    // Calls the method getKeys() in IGame 60 times/sec and updated the view
                    Label keys = view.getNrKeys();
                    keys.setText(model.getKeys().toString());

                    // Calls the method getPoints() in IGame 60 times/sec and updated the view
                    Label points = view.getText();
                    points.setText(model.getPoints().toString());
                }
            }
        };
        animationTimer.start();
    }
}