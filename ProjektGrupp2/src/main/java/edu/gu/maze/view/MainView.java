package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by xiang-yu on 2015-05-03.
 */
public class MainView{
    Stage stage;
    private Scene mainScene;
    private VBox vBoxlayout;
    private Button playButton, highScoreButton;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }


    public MainView(Stage primaryStage){
        stage = primaryStage;
        stage.setTitle("Maze");
        playButton = new Button("Play the game");
        playButton.setOnAction(e -> {
            pcs.firePropertyChange("playButton", "value1", "value2");
        });
        highScoreButton = new Button("High Score");
        highScoreButton.setOnAction(e -> {
            pcs.firePropertyChange("highScoreButton", "value1", "value2");
        });
        vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(playButton,highScoreButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        mainScene = new Scene(vBoxlayout, 1000, 600);
        stage.setScene(mainScene);
        stage.show();
    }



}
