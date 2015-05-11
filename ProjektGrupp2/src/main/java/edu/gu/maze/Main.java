package edu.gu.maze;

import edu.gu.maze.controller.MainController;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MainView;
import edu.gu.maze.view.Player;
import javafx.application.Application;
import javafx.stage.Stage;

public final class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Player player = new Player();

        //model
        IGame model = new Game();

        //view
        MainView view = new MainView(primaryStage);

        System.out.print(player +"\n");

        //mainController
        MainController mainController = new MainController(model, view, primaryStage, player);

    }
}
