package edu.gu.maze;

import edu.gu.maze.controller.GameController;
import edu.gu.maze.model.IGame;
import edu.gu.maze.model.Map;
import edu.gu.maze.view.MainView;
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

        //model
        IGame model = new Map();

        //view
        MainView view = new MainView(primaryStage);

        //controller
        GameController controller = new GameController(model, view);
    }
}
