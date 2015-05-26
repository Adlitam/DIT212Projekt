package edu.gu.maze.view;

import edu.gu.maze.controller.HighScoreController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HighScoreView{
    private Button backButton;
    private BorderPane borderPaneLayout;

    private Label player, score;
    private  HBox highScore;

    public HighScoreView(Stage stage){
        stage.setTitle("Maze");
        borderPaneLayout = new BorderPane();

        //Create the layout
        createList();
        createTop();
        createBackButton();

        borderPaneLayout.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        //Sets the scene
        Scene highScoreScene = new Scene(borderPaneLayout, 800, 620);
        stage.setScene(highScoreScene);
    }
  public void createList(){

        VBox vBoxCenter = new VBox();

        for(int i = 0; i < 3; i++){
            if(i == 0) {
                createLabel("player1", "score1");
            }else if(i == 1){
                createLabel("player2", "score2");
            }else if(i == 2){
                createLabel("player3", "score3");
            }
            vBoxCenter.getChildren().addAll(highScore);

       }


        vBoxCenter.setAlignment(Pos.CENTER);
      vBoxCenter.setSpacing(100);
        vBoxCenter.setStyle("-fx-border-color: Black");
        //Added the hBox to the layout.
        borderPaneLayout.setCenter(vBoxCenter);


    }

    private void createLabel(String playerName, String scorePlayer){

        player = new Label(playerName);
        player.setFont(new Font(20));
        score = new Label(scorePlayer);
        score.setFont(new Font(20));
        highScore = new HBox();
        highScore.getChildren().addAll(player,score);
        highScore.setSpacing(100);
        highScore.setAlignment(Pos.CENTER);
        highScore.setStyle("-fx-border-color: Black");


    }

    public void createTop(){
        //The title and the font
        Label title = new Label("High Score");
        title.setFont(new Font("Cambria", 40));

        HBox hBoxTop = new HBox();
        hBoxTop.getChildren().addAll(title);
        hBoxTop.setAlignment(Pos.CENTER);

        borderPaneLayout.setTop(hBoxTop);
    }

    public void createBackButton(){
        //Create the backbutton
        HBox hBoxlayout = new HBox();
        backButton = new Button("Back to start");
        hBoxlayout.getChildren().add(backButton);
        hBoxlayout.setAlignment(Pos.CENTER);
        borderPaneLayout.setBottom(hBoxlayout);
    }

    public void addController(HighScoreController c){
        backButton.setOnAction(c);
    }

    public Button getBackButton(){
        return backButton;
    }
}
