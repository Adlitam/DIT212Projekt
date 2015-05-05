package edu.gu.maze;

//import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
//import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import edu.gu.maze.View.MainView;
import javafx.application.Application;
import javafx.stage.Stage;




        public final class Main extends Application {

            public static void main(String[] args) {
                launch(args);


            }

            @Override
            public void start(Stage primaryStage) throws Exception {
                new MainView(primaryStage);


/*
            //model
            IGame model = new Game();

            //view
            MainView view = new MainView(primaryStage);

            //controller
            GameController controller = new GameController(model, view);
            */
            }

        }

