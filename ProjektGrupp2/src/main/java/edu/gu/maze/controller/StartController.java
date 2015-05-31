package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.util.Constants;
import edu.gu.maze.model.IGame;
import edu.gu.maze.util.ResourceReader;
import edu.gu.maze.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class StartController implements EventHandler<ActionEvent> {
    private final Game model;
    private final Stage stage;
    private final StartView view;
    private InfoController infoController;
    private String[] playerName = new String[3];
    private int[] playerType = new int[3];

    public StartController(IGame model, StartView view, Stage primaryStage){
        this.model = (Game) model;
        this.stage = primaryStage;
        this.view = view;
        setControllers();
        getPlayerInfo();
    }

    private void getPlayerInfo(){

        //Gets the players name and adding it to an array
        final String player1 = model.getPlayerName(Constants.SLOT1);
        final String player2 = model.getPlayerName(Constants.SLOT2);
        final String player3 = model.getPlayerName(Constants.SLOT3);

        playerName[0] = player1;
        playerName[1] = player2;
        playerName[2] = player3;

        //gets the players type and adding it to an array
        final int type1 = model.getPlayerType(Constants.SLOT1);
        final int type2 = model.getPlayerType(Constants.SLOT2);
        final int type3 = model.getPlayerType(Constants.SLOT3);

        playerType[0] = type1;
        playerType[1] = type2;
        playerType[2] = type3;
    }

    //sets all the listeners on the view
    private void setControllers(){
        this.view.getBackButton().setOnAction(this);
        this.view.getSlot1Button().setOnAction(this);
        this.view.getSlot2Button().setOnAction(this);
        this.view.getSlot3Button().setOnAction(this);
        this.view.getDeleteSlot1().setOnAction(this);
        this.view.getDeleteSlot2().setOnAction(this);
        this.view.getDeleteSlot3().setOnAction(this);
    }



    //handle method for when the player presses the different slots and the back to start button.
    @Override
    public void handle(ActionEvent event) {
        final Object b = event.getSource();
        if(b == view.getSlot1Button()){
            if(view.checkSlot1()){
                model.setStopLoops(false);
                final InfoView infoView = new InfoView();
                infoController = new InfoController(model, infoView);
                final InputOutputView inputView = new InputOutputView();
                new InputOutputViewController(model, inputView, stage);
                final MapView mapView = new MapView();
                model.addPropertyChangeListener(mapView);
                model.addPropertyChangeListener(inputView);
                new GameView(stage, mapView, infoView, inputView);
                model.selectPlayer(Constants.SLOT1);
                model.setCurrentLevel(Constants.MAP1);
                model.setCurrentMatch(ResourceReader.readMapForModel(model.getCurrentMapFilePath()));
                new MapController(model, mapView, stage);
                infoController.setAnimationTimer();
            }else {
                final CreatePlayerView createPlayerView1 = new CreatePlayerView(stage, Constants.SLOT1);
                new CreatePlayerController(model, createPlayerView1, stage);
            }
        }
        if(b == view.getSlot2Button()){
            if(view.checkSlot2()){

                final InfoView infoView = new InfoView();
                infoController = new InfoController(model, infoView);
                final InputOutputView inputView = new InputOutputView();
                new InputOutputViewController(model, inputView, stage);
                final MapView mapView = new MapView();
                model.addPropertyChangeListener(mapView);
                model.addPropertyChangeListener(inputView);
                new GameView(stage, mapView, infoView, inputView);
                model.selectPlayer(Constants.SLOT2);
                model.setCurrentLevel(Constants.MAP1);
                model.setCurrentMatch(ResourceReader.readMapForModel(model.getCurrentMapFilePath()));
                new MapController(model, mapView, stage);
                infoController.setAnimationTimer();
            }else {
                final CreatePlayerView createPlayerView2 = new CreatePlayerView(stage, Constants.SLOT2);
                new CreatePlayerController(model, createPlayerView2, stage);
            }
        }
        if(b == view.getSlot3Button()){
            if(view.checkSlot3()){
                final InfoView infoView = new InfoView();
                infoController = new InfoController(model, infoView);
                final InputOutputView inputView = new InputOutputView();
                new InputOutputViewController(model, inputView, stage);
                final MapView mapView = new MapView();
                model.addPropertyChangeListener(mapView);
                model.addPropertyChangeListener(inputView);
                new GameView(stage, mapView, infoView, inputView);
                model.selectPlayer(Constants.SLOT2);
                model.setCurrentLevel(Constants.MAP1);
                model.setCurrentMatch(ResourceReader.readMapForModel(model.getCurrentMapFilePath()));
                new MapController(model, mapView, stage);
                infoController.setAnimationTimer();
            }else{
                final CreatePlayerView createPlayerView3 = new CreatePlayerView(stage, Constants.SLOT3);
                new CreatePlayerController(model, createPlayerView3, stage);
            }
        }
        if(b == view.getBackButton()){
            final MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
        deletePlayer(event);
    }

    //Extra method for the handle
    private void deletePlayer(ActionEvent event){
        final Object b = event.getSource();
        if(b == view.getDeleteSlot1()){
            model.deletePlayer(Constants.SLOT1);
            getPlayerInfo();
            final StartView startView = new StartView(playerName,playerType, stage);
            new StartController(model, startView, stage);
        }
        if(b == view.getDeleteSlot2()){
            model.deletePlayer(Constants.SLOT2);
            getPlayerInfo();
            final StartView startView = new StartView(playerName,playerType, stage);
            new StartController(model, startView, stage);
        }
        if(b == view.getDeleteSlot3()){
            model.deletePlayer(Constants.SLOT3);
            getPlayerInfo();
            final StartView startView = new StartView(playerName,playerType, stage);
            new StartController(model, startView, stage);
        }
    }
}