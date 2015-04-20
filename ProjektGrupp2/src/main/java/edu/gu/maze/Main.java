package edu.gu.maze;


import edu.gu.maze.view.MazeMainView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


/*
  Application entry class (if using standard java and Swing)
*/
public final class Main extends Application {

    private static final int POS = 20;

	public static void main(String[] args) {

       launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Maze");
        Circle circle = new Circle(50,100,10, Color.RED);
        Group layout = new Group(new Label(),circle);

        /*

        button = new Button();
        button.setText("Click me!");

        button.setOnAction(new EventHandler(){

            System.out.printLn("Some text");

        });

        */
        Scene scene = new Scene(layout,500,500);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    circle.setCenterY(circle.getCenterY() - POS); break;
                    case RIGHT: circle.setCenterX(circle.getCenterX() + POS); break;
                    case DOWN:  circle.setCenterY(circle.getCenterY() + POS); break;
                    case LEFT:  circle.setCenterX(circle.getCenterX() - POS); break;
                }
            }
        });




        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
