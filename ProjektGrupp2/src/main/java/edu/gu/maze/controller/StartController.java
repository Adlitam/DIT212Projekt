package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.util.Constants;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class StartController implements EventHandler<ActionEvent> {
    private Game model;
    private Stage stage;
    private StartView view;
    private InfoController infoController;
    String[] playerName = new String[3];
    int[] playerType = new int[3];
    int[] playerScore = new int[3];

    public StartController(IGame model, StartView view, Stage primaryStage){
        this.model = (Game) model;
        this.stage = primaryStage;
        this.view = view;
        this.view.getBackButton().setOnAction(this);
        this.view.getSlot1Button().setOnAction(this);
        this.view.getSlot2Button().setOnAction(this);
        this.view.getSlot3Button().setOnAction(this);
        this.view.getDeleteSlot1().setOnAction(this);
        this.view.getDeleteSlot2().setOnAction(this);
        this.view.getDeleteSlot3().setOnAction(this);
        getPlayerInfo();
    }

    private void getPlayerInfo(){
        //gets the players score and adding it to an array
        int score1 = model.getPlayerTotalScore(Constants.SLOT1);
        int score2 = model.getPlayerTotalScore(Constants.SLOT2);
        int score3 = model.getPlayerTotalScore(Constants.SLOT3);

        playerScore[0] = score1;
        playerScore[1] = score2;
        playerScore[2] = score3;

        //Gets the players name and adding it to an array
        String player1 = model.getPlayerName(Constants.SLOT1);
        String player2 = model.getPlayerName(Constants.SLOT2);
        String player3 = model.getPlayerName(Constants.SLOT3);

        playerName[0] = player1;
        playerName[1] = player2;
        playerName[2] = player3;

        //gets the players type and adding it to an array
        int type1 = model.getPlayerType(Constants.SLOT1);
        int type2 = model.getPlayerType(Constants.SLOT2);
        int type3 = model.getPlayerType(Constants.SLOT3);

        playerType[0] = type1;
        playerType[1] = type2;
        playerType[2] = type3;
    }

    //initializes all the views and controllers needed for the actual gameplay view.
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

    //handle method for when the player presses the different slots and the back to start button.
    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getSlot1Button()){
            if(view.checkSlot1()){
                play();
                model.selectPlayer(Constants.SLOT1);
                model.startMatch(Constants.MAP1);
                infoController.setAnimationTimer();
            }else {
                CreatePlayerView createPlayerView1 = new CreatePlayerView(stage, Constants.SLOT1);
                new CreatePlayerController(model, createPlayerView1, stage);
            }
        }
        if(b == view.getSlot2Button()){
            if(view.checkSlot2()){
                play();
                model.selectPlayer(Constants.SLOT2);
                model.startMatch(Constants.MAP1);
                infoController.setAnimationTimer();
            }else {
                CreatePlayerView createPlayerView2 = new CreatePlayerView(stage, Constants.SLOT2);
                new CreatePlayerController(model, createPlayerView2, stage);
            }
        }
        if(b == view.getSlot3Button()){
            if(view.checkSlot3()){
                play();
                model.selectPlayer(Constants.SLOT2);
                model.startMatch(Constants.MAP1);
                infoController.setAnimationTimer();
            }else{
                CreatePlayerView createPlayerView3 = new CreatePlayerView(stage, Constants.SLOT3);
                new CreatePlayerController(model, createPlayerView3, stage);
            }
        }
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
        deletePlayer(event);
    }

    private void deletePlayer(ActionEvent event){
        Object b = event.getSource();
        if(b == view.getDeleteSlot1()){
            model.deletePlayer(Constants.SLOT1);
            getPlayerInfo();
            StartView startView = new StartView(stage,playerName,playerType);
            new StartController(model, startView, stage);
        }
        if(b == view.getDeleteSlot2()){
            model.deletePlayer(Constants.SLOT2);
            getPlayerInfo();
            StartView startView = new StartView(stage,playerName,playerType);
            new StartController(model, startView, stage);
        }
        if(b == view.getDeleteSlot3()){
            model.deletePlayer(Constants.SLOT3);
            getPlayerInfo();
            StartView startView = new StartView(stage,playerName,playerType);
            new StartController(model, startView, stage);
        }
    }
}