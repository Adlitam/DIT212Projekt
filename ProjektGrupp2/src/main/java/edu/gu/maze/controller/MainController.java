package edu.gu.maze.controller;

import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.util.Constants;
import edu.gu.maze.view.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class MainController implements EventHandler<ActionEvent> {
    private final Game model;
    private Stage stage;
    private final MainView view;
    private String[] playerName = new String[3];
    private int[] playerType = new int[3];
    private int[] playerScore = new int[3];

    public MainController(IGame model, MainView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = (Game) model;
        this.view = view;
        this.view.getAboutButton().setOnAction(this);
        this.view.getHighScoreButton().setOnAction(this);
        this.view.getPlayButton().setOnAction(this);
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

    //handle method for when the player presses the highScoreButton, playButton and aboutButton.
    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getHighScoreButton()){
            getPlayerInfo();
            HighScoreView highScoreView = new HighScoreView(stage,playerName,playerScore);
            new HighScoreController(model, highScoreView, stage);
        }
        if(b == view.getPlayButton()){
            getPlayerInfo();
            StartView startView = new StartView(stage,playerName,playerType);
            new StartController(model, startView, stage);
        }
        if(b == view.getAboutButton()){
            AboutView aboutView = new AboutView(stage);
            new AboutController(model, aboutView, stage);
        }
    }
}