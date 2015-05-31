package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.util.ResourceReader;
import edu.gu.maze.util.SavedInformationHandler;
import edu.gu.maze.view.CongratzView;
import edu.gu.maze.view.MapView;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MapController implements EventHandler<KeyEvent> {
    private final IGame model;
    private final Stage stage;
    private final MapView view;
    private AnimationTimer animationTimer;

    public MapController(IGame model, MapView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.getMap().setOnKeyPressed(this);
        initializeMap();
        initializeTimer();
    }

    //initializes the AnimationTimer that check if a player has finished a map and then creates a CongratzView.
    private void initializeTimer(){
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(model.isStopLoops()){
                    animationTimer.stop();
                    if(model.isTheGameDone()) {
                        SavedInformationHandler.saveGame((Game) model);
                        final CongratzView congratzView = new CongratzView(stage);
                        new CongratzController(model, congratzView, stage);
                        view.inactivate();
                    }
                }
            }
        };
        animationTimer.start();
    }

    //Administer the appropriate action in the model whenever the player presses the UP, DOWN, LEFT and RIGHT arrow keys.
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

    //Initializes the GridPane in the mapView that the MapController is associated with,
    //with the type of character and starting positions for the character.
    private void initializeMap(){
        view.setMap(ResourceReader.readMapForView(model.getCurrentMapFilePath()));
        final int startX = ResourceReader.getPlayerViewStartX(model.getCurrentMapFilePath());
        final int startY = ResourceReader.getPlayerViewStartY(model.getCurrentMapFilePath());
        final int type = model.getPlayerType();
        this.view.initializePlayer(startX, startY, type);
        this.view.initializeGrid(startX, startY);
    }
}