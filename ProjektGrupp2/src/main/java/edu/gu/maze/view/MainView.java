package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by xiang-yu on 2015-05-03.
 */
public class MainView{
    Stage stage;
    Button createPlayer;
    Button highScoreButton;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }



    public MainView(Stage primaryStage){
        stage = primaryStage;
        stage.setTitle("Maze");

        createPlayButton();
        createHighScoreButton();

        VBox vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(createPlayer,highScoreButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        vBoxlayout.setSpacing(50);
        Scene mainScene = new Scene(vBoxlayout, 800, 620);
        //stage.setResizable(false);
        stage.setScene(mainScene);
        stage.show();
    }


    public void createPlayButton(){
        //Creates the PlayButton
        createPlayer = new Button("Play");
        createPlayer.setFont(new Font("Cambria", 20));
        createPlayer.setOnAction(e ->
                        pcs.firePropertyChange("Play", "value1", "value2")
        );

    }

    public void createHighScoreButton(){

        //Creates the highscoreButton
        highScoreButton = new Button("High Score");
        highScoreButton.setFont(new Font("Cambria", 20));
        highScoreButton.setOnAction(e ->
                        pcs.firePropertyChange("highScoreButton", "value1", "value2")
        );
    }



}
