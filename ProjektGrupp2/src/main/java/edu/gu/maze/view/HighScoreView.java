package edu.gu.maze.view;

import edu.gu.maze.controller.HighScoreController;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.xml.soap.Text;


public class HighScoreView{
    private Button backButton,totalScoreButton;
    private BorderPane borderPaneLayout;

    private Label player, score;
    private  HBox highScore;
    String player1,player2,player3;
    int score1,score2,score3;
    HBox hBoxlayout = new HBox();

    public HighScoreView(Stage stage, String[] playerName, int[] playerScore){
        
        stage.setTitle("Maze");
        borderPaneLayout = new BorderPane();

        //Create the layout
        getPlayerInfo(playerName,playerScore);
        createList();
        createTop();
        createBotton();

        //Sets the background
        borderPaneLayout.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        //Sets the scene
        Scene highScoreScene = new Scene(borderPaneLayout, 800, 620);
        stage.setScene(highScoreScene);
    }

    private void getPlayerInfo(String[] playerName, int[] playerScore){
        //Gets the players name
        player1 = playerName[0];
        player2 = playerName[1];
        player3 = playerName[2];

        //gets the players score
        score1 = playerScore[0];
        score2 = playerScore[1];
        score3 = playerScore[2];
    }

    @SuppressFBWarnings("LSC_LITERAL_STRING_COMPARISON")
    private void createList(){

        VBox vBoxCenter = new VBox();

        //creates a list for every slot with the total score
        for(int i = 0; i < 3; i++){

            if(i == 0) {
                if(!player1.equals("")) {
                    createLabel(player1, score1);
                }else{
                    createEmptyLabel();
                }
            }else if(i == 1){
                if(!player2.equals("")) {
                    createLabel(player2, score2);
                }else{
                    createEmptyLabel();
                }
            }else if(i == 2){
                if(!player3.equals("")) {
                    createLabel(player3, score3);
                }else{
                    createEmptyLabel();
                }
            }

            vBoxCenter.getChildren().addAll(highScore);

       }


        vBoxCenter.setAlignment(Pos.CENTER);
        vBoxCenter.setSpacing(100);
        vBoxCenter.setStyle("-fx-border-color: Black");
        //Added the hBox to the layout.
        borderPaneLayout.setCenter(vBoxCenter);


    }

    //Create one panel for the score with the player name and the scores for ever slot
    private void createLabel(String playerName, int scorePlayer){

            player = new Label(playerName);
            player.setFont(new Font("Verdana", 40));
            score = new Label("" + scorePlayer);
            score.setFont(new Font("Verdana", 40));
            highScore = new HBox();
            highScore.getChildren().addAll(player, score);
            highScore.setSpacing(100);
            highScore.setAlignment(Pos.CENTER);
            highScore.setStyle("-fx-border-color: Black");


    }

    //Creates a empty panel if the slot is empty
    private void createEmptyLabel(){

        player = new Label();
        player.setFont(new Font("Verdana", 40));
        score = new Label();
        score.setFont(new Font("Verdana", 40));
        highScore = new HBox();
        highScore.getChildren().addAll(player, score);
        highScore.setSpacing(100);
        highScore.setAlignment(Pos.CENTER);
        highScore.setStyle("-fx-border-color: Black");

    }

    public void createTop(){
        //The title and the font
        Label title = new Label("TotalScore for every slot.");
        title.setFont(new Font("Cambria", 40));

        HBox hBoxTop = new HBox();
        hBoxTop.getChildren().addAll(title);
        hBoxTop.setAlignment(Pos.CENTER);

        borderPaneLayout.setTop(hBoxTop);
    }

    public void createBotton(){
        //Create the botton

        backButton = new Button("Back to start");
        totalScoreButton = new Button("HighScore");
        hBoxlayout.getChildren().addAll(backButton, totalScoreButton);
        hBoxlayout.setAlignment(Pos.CENTER);
        hBoxlayout.setSpacing(50);
        borderPaneLayout.setBottom(hBoxlayout);


    }

    //Adding the event on the buttons
    public void addController(HighScoreController c){
        backButton.setOnAction(c);
        totalScoreButton.setOnAction(c);
    }

    //returns the buttons
    public Button getBackButton(){
        return backButton;
    }

    public Button getTotalScoreButton() {
        return totalScoreButton;
    }
}
