package edu.gu.maze.view;

import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Observable;

/**
 * Created by xiang-yu on 2015-05-03.
 */
public class MainView extends Observable{
    Stage stage;
    Scene mainScene, gameScene, highScene;

    public MainView(Stage primaryStage){
        stage = primaryStage;
    }
}
