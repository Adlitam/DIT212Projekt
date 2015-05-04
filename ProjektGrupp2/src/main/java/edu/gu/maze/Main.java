package edu.gu.maze;

import edu.gu.maze.controller.GameController;
import edu.gu.maze.model.IGame;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.Map;
import edu.gu.maze.view.MainView;
import edu.gu.maze.view.MazeMainView;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;

public final class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //read serialized Game object, if present.
        try(
                InputStream file = new FileInputStream("Game.ser");
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream (buffer);
                )
        {
            Game game = (Game)input.readObject();
        }
        catch(FileNotFoundException ex){
            //TODO: This is where a new Game.ser file is made, if none is present. It should
            //be initialized with all hard-coded maps, but no other information.
        }
        new MazeMainView(primaryStage);

        //model
        IGame model = new Map();

        //view
        MainView view = new MainView(primaryStage);

        //controller
        GameController controller = new GameController(model, view);
    }
}
