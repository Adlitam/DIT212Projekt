package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.CongratzView;
import edu.gu.maze.view.MapView;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MapController implements EventHandler<KeyEvent> {
    private final IGame model;
    private Stage stage;
    private final MapView view;
    private AnimationTimer animationTimer;

    public MapController(IGame model, MapView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.getMap().setOnKeyPressed(this);
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(model.gamesDone()){
                    animationTimer.stop();
                    CongratzView congratzView = new CongratzView(stage);
                    new CongratzController(model, congratzView, stage);
                }
            }
        };
        animationTimer.start();
    }

    //handle method for when the player presses the UP, DOWN, LEFT and RIGHT arrow keys.
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                model.moveUp();
                event.consume();
                break;
            case DOWN:
                model.moveDown();
                event.consume();
                break;
            case LEFT:
                model.moveLeft();
                event.consume();
                break;
            case RIGHT:
                model.moveRight();
                event.consume();
                break;
            default:
        }
    }
}