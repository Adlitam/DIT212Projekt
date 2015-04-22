package edu.gu.maze.view;


import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MazeMainView {

    Scene mainScene, gameScene;

    GameView gameView = new GameView();

    BorderPane layout;

    Button playButton;

    public MazeMainView(Stage stage) {
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        //Sets the title of the window
        stage.setTitle("Maze");

        //The layout
        layout = new BorderPane();




        //The play button
        playButton = new Button("Play the game");

        playButton.setOnAction(e -> stage.setScene(gameView.gameView(gameScene)));

        layout.setCenter(playButton);


        //Sets the scene
        mainScene = new Scene(layout, screenSize.getWidth(), screenSize.getHeight());

        stage.setScene(mainScene);

        //Show the window
        stage.show();

    }

}



