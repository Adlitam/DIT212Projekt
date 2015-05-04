package edu.gu.maze.view;


import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.BorderPane;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MazeMainView {

    Scene mainScene, gameScene, highScene;

    GameView gameView = new GameView();
    HighScoreView highView = new HighScoreView();

    BorderPane layout;

    Button playButton, highScoreButton;

    public MazeMainView(Stage stage) {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        //Sets the title of the window
        stage.setTitle("Maze");

        //The layout
        layout = new BorderPane();

        VBox center = new VBox();

        layout.setCenter(center);


        //The play button
        playButton = new Button("Play the game");

        playButton.setOnAction(e -> stage.setScene(gameView.getGameScene(gameScene)));



        //The Highscore Button
        highScoreButton = new Button("High Score");

        highScoreButton.setOnAction(e -> stage.setScene(highView.highScore(highScene)));


        center.getChildren().addAll(playButton,highScoreButton);


        //Sets the scene
        mainScene = new Scene(layout, 1000, 600);
        //mainScene = new Scene(layout, screenSize.getWidth(), screenSize.getHeight());

        stage.setScene(mainScene);

        //Show the window
        stage.show();

    }

}



