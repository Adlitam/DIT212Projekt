package edu.gu.maze;


import edu.gu.maze.view.GameView;

import edu.gu.maze.view.MazeMainView;
import javafx.application.Application;
import javafx.stage.Stage;


public final class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        new MazeMainView(primaryStage);
    }
}
