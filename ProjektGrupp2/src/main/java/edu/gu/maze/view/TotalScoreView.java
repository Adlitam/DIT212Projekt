package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TotalScoreView {

    private final BorderPane layput;
    private Button backButton;
    //A list of highscore and playername, date .
    private final String[] score;

    public TotalScoreView(Stage stage, String... score){
        stage.setTitle("Maze");
        layput = new BorderPane();

        this.score = score;

        //Create the layout
        createList();
        createBackButton();
        createTop();

        //sets the background onthe the scene
        layput.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        //Sets the scene
        final Scene highScoreScene = new Scene(layput, 800, 620);
        stage.setScene(highScoreScene);
    }

    //shows the list with all highscore for every player that
    //have played the game
    private void createList(){
        final VBox vBox = new VBox();
        Label player;
        if(score.length == 0){

           player = new Label("The highscore is empty");
            player.setTextFill(Paint.valueOf("Red"));
            player.setFont(new Font(20));
            vBox.getChildren().addAll(player);
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);

        }else{

            for(final String x : score){

                player = new Label(x);
                player.setFont(new Font(20));
                vBox.getChildren().addAll(player);
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(20);

            }
        }

        layput.setCenter(vBox);

    }

    //Shows the title of the stage
    private void createTop(){

        final Label title = new Label("High Score");
        title.setFont(new Font(40));
        final HBox hBox = new HBox();
        hBox.getChildren().addAll(title);
        hBox.setAlignment(Pos.CENTER);
        layput.setTop(hBox);


    }

    //Sets the backbutton on the bottom of the stage
    private void createBackButton(){

        backButton = new Button("Back to start");
        final HBox hBox = new HBox();
        hBox.getChildren().addAll(backButton);
        hBox.setAlignment(Pos.CENTER);
        layput.setBottom(hBox);


    }

    //Returns the backbutton
    public Button getBackButton() {
        return backButton;
    }
}
