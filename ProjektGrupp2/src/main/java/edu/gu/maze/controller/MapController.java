package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MapView;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class MapController implements EventHandler<KeyEvent> {
    private IGame model;
    private Stage stage;
    private MapView view;

    public MapController(IGame model, MapView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addController(this);
    }

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
        }
    }
}
