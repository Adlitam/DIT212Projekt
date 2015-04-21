package edu.gu.maze.view;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class MazeMainView {
    //Stage


    //Scenes
    Scene mainScene,gameScene;

    //Instance
    GameView gameView = new GameView();

    //Layouts
    BorderPane layout;

    //Buttons
    Button playButton;



    public MazeMainView(Stage stage){

        //Sets the title of the window
        stage.setTitle("Maze");

        //The layout
        layout = new BorderPane();

        //The play button
        playButton = new Button("Play the game");
        playButton.setOnAction(e -> stage.setScene(gameView.gameView(gameScene)));

        layout.setCenter(playButton);


        //Sets the scene
        mainScene = new Scene(layout,500,500);

        stage.setScene(mainScene);

        //Show the window
        stage.show();
    }





}



