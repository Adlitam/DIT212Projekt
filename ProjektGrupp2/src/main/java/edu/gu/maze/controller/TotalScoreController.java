package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MainView;
import edu.gu.maze.view.TotalScoreView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 * Created by Matildaandersson on 15-05-27.
 */
public class TotalScoreController implements EventHandler<ActionEvent> {

    private final IGame model;
    private final Stage stage;
    private final TotalScoreView view;

    public TotalScoreController(IGame model, TotalScoreView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.getBackButton().setOnAction(this);
    }

    //handle method for when the player presses the back to start button.
    @Override
    public void handle(ActionEvent event) {
        final Object b = event.getSource();
        if(b == view.getBackButton()){
            final MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }

    }
}