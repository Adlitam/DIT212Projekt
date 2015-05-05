package edu.gu.maze.View;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import edu.gu.maze.MazeTest;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * Created by Matildaandersson on 15-05-05.
 */
public class MainView extends Application {


    public static void main (String[] arg){

        launch(arg);

    }

    @Override
    public void start(final Stage primaryStage) throws Exception {

        primaryStage.setTitle("Maze");

        FlowPane layout = new FlowPane();

        final Scene scene = new Scene(layout,1000,600);

        Button b = new Button("Game");

        layout.getChildren().add(b);
        GameView gv = new GameView();
        final Scene g;

        b.setOnAction(e -> newGame());


        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void newGame(){
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        new LwjglApplication(new MazeTest(), config);

    }

}
