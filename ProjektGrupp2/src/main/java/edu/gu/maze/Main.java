package edu.gu.maze;

import edu.gu.maze.controller.MainController;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.util.SavedInformationHandler;
import edu.gu.maze.view.MainView;
import javafx.application.Application;
import javafx.stage.Stage;

public final class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //model
        IGame model = SavedInformationHandler.retrieveGame();

        //view
        MainView view = new MainView(primaryStage);

        //mainController
        MainController mainController = new MainController(model, view, primaryStage);
        //view.addPropertyChangeListener(mainController);
    }
}
