package edu.gu.maze.controller;

import edu.gu.maze.util.Constants;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.event.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CreatePlayerController implements EventHandler<ActionEvent> {
    private Game model;
    private CreatePlayerView view;
    private InfoController infoController;
    private Stage stage;
    private int type;
    private MouseEventController mec;

    public CreatePlayerController(IGame model, CreatePlayerView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = (Game) model;
        this.view = view;
        mec = new MouseEventController();
        this.view.addController(this);
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

    // Starts the GameView
    private void play(){
        InfoView infoView = new InfoView();
        infoController = new InfoController(model, infoView);
        InputOutputView inputView = new InputOutputView();
        new InputOutputViewController(model, inputView, stage);
        MapView mapView = new MapView();
        model.addPropertyChangeListener(mapView);
        model.addPropertyChangeListener(inputView);
        new MapController(model, mapView, stage);
        new GameView(stage, mapView, infoView, inputView);
    }

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
        if(b == view.getPlayButton()){
            TextField input = view.getName();
            String name = input.getText();
            if(name.length() > 0) {
                int slot = view.getSlot();
                System.out.println("Name: " + name);
                System.out.println("Type: " + type);
                System.out.println("Slot: " + slot);
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
            Object b = event.getSource();
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

    public MouseEventController getMec(){
        return mec;
    }
}