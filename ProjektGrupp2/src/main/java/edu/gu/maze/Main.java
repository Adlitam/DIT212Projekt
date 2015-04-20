package edu.gu.maze;


import edu.gu.maze.view.MazeMainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/*
  Application entry class (if using standard java and Swing)
*/
public final class Main extends Application {


	public static void main(String[] args) {

       launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Maze");

        FlowPane layout = new FlowPane();
        /*

        button = new Button();
        button.setText("Click me!");

        button.setOnAction(new EventHandler(){

            System.out.printLn("Some text");

        });

        */

        Scene scene = new Scene(layout);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
