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

        Button highScoreButton = new Button("High Score");
        highScoreButton.setOnAction(e ->
            pcs.firePropertyChange("highScoreButton", "value1", "value2")
        );

        Button createPlayer = new Button("Create Player");
        createPlayer.setOnAction(e ->
                        pcs.firePropertyChange("createPlayerButton", "value1", "value2")
        );

        VBox vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(highScoreButton,createPlayer);
        vBoxlayout.setAlignment(Pos.CENTER);
        Scene mainScene = new Scene(vBoxlayout, 800, 600);
        stage.setScene(mainScene);
        stage.show();
    }



}
