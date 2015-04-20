package edu.gu.maze.view;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;


/**
 * Created by Matildaandersson on 15-04-15.
 */
public class MazeMainView extends Application {


    Button button;

    public MazeMainView(String[] args){

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
