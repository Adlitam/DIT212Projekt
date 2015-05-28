package edu.gu.maze.controller;

import edu.gu.maze.util.Constants;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.util.SavedInformationHandler;
import edu.gu.maze.view.*;
import javafx.event.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CreatePlayerController implements EventHandler<ActionEvent> {
    private final Game model;
    private final CreatePlayerView view;
    private InfoController infoController;
    private final Stage stage;
    private int type;


    public CreatePlayerController(IGame model, CreatePlayerView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = (Game) model;
        this.view = view;
        final MouseEventController mec = new MouseEventController();
        this.view.getBackButton().setOnAction(this);
        this.view.getPlayButton().setOnAction(this);
        this.view.getWarrior().setOnMouseClicked(mec);
        this.view.getMage().setOnMouseClicked(mec);
        this.view.getThief().setOnMouseClicked(mec);
    }

    //disables the icons that were not selected and makes them invisible
    private void disableIcons(int t){
        ImageView temp1;
        ImageView temp2;
        switch(t){
            case Constants.MAGE:
                temp1 = view.getWarrior();
                temp2 = view.getThief();
                break;
            case Constants.WARRIOR:
                temp1 = view.getMage();
                temp2 = view.getThief();
                break;
            case Constants.THIEF:
                temp1 = view.getMage();
                temp2 = view.getWarrior();
                break;
            default:
                temp1 = null;
                temp2 = null;
                break;
        }
        assert temp1 != null;
        temp1.setDisable(true);
        temp2.setDisable(true);
        temp1.setVisible(false);
        temp2.setVisible(false);
    }

    //initializes all the views and controllers needed for the actual gameplay view.
    private void play(){
        final InfoView infoView = new InfoView();
        infoController = new InfoController(model, infoView);
        final InputOutputView inputView = new InputOutputView();
        new InputOutputViewController(model, inputView, stage);
        final MapView mapView = new MapView();
        model.addPropertyChangeListener(mapView);
        model.addPropertyChangeListener(inputView);
        new MapController(model, mapView, stage);
        new GameView(stage, mapView, infoView, inputView);
    }

    //handle method for when the player presses the back to start button and play button.
    @Override
    public void handle(ActionEvent event) {
        final Object b = event.getSource();
        if(b == view.getBackButton()){
            final MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
        if(b == view.getPlayButton()){
            final TextField input = view.getName();
            final String name = input.getText();
            SavedInformationHandler.saveGame(model);
            if(name.length() > 0) {
                final int slot = view.getSlot();

                model.createPlayer(slot, name, type);
                play();
                model.startMatch(Constants.MAP1);
                infoController.setAnimationTimer();
            }else{
                input.setPromptText("Fill in your name!!!");
            }
        }
    }
    //inner class for handling MouseEvents
    private class MouseEventController implements EventHandler<javafx.scene.input.MouseEvent>{
        @Override
        public void handle(javafx.scene.input.MouseEvent event) {
            final Object b = event.getSource();
            if(b == view.getMage()){
                type = Constants.MAGE;
                disableIcons(type);
            }
            if(b == view.getWarrior()){
                type = Constants.WARRIOR;
                disableIcons(type);
            }
            if(b == view.getThief()){
                type = Constants.THIEF;
                disableIcons(type);
            }
        }
    }
}