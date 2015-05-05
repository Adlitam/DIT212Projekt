package edu.gu.maze;

import edu.gu.maze.controller.Controller;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public final class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //new MazeMainView(primaryStage);

        //model
        IGame model = new Game();

        //view
        MainView view = new MainView(primaryStage);

        //controller
        Controller controller = new Controller(model, view);
    }
}
