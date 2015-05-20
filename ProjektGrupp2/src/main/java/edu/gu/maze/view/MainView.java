package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    Button aboutButton;
    BorderPane layout;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }



    public MainView(Stage primaryStage){
        stage = primaryStage;
        stage.setTitle("Maze");

        layout = new BorderPane();

        HBox top = new HBox();

        Label titel = new Label("Maze");
        titel.setFont(new Font(40));

        top.getChildren().addAll(titel);
        top.setAlignment(Pos.CENTER);

        layout.setTop(top);


        createPlayButton();
        createHighScoreButton();
        createAboutButton();

        VBox vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(createPlayer,highScoreButton,aboutButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        vBoxlayout.setSpacing(50);

        layout.setCenter(vBoxlayout);
        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");
        Scene mainScene = new Scene(layout, 800, 600);
        //stage.setResizable(false);
        stage.setScene(mainScene);
        stage.show();
    }


    public void createPlayButton(){
        //Creates the PlayButton
        createPlayer = new Button("Play");
        createPlayer.setPrefWidth(200);
        createPlayer.setFont(new Font("Cambria", 20));
        createPlayer.setOnAction(e ->
                        pcs.firePropertyChange("Play", "value1", "value2")
        );

    }

    public void createHighScoreButton(){

        //Creates the highscoreButton
        highScoreButton = new Button("High Score");
        highScoreButton.setPrefWidth(200);
        highScoreButton.setFont(new Font("Cambria", 20));
        highScoreButton.setOnAction(e ->
                        pcs.firePropertyChange("highScoreButton", "value1", "value2")
        );
    }

    private void createAboutButton(){

        //Creats the About button
        aboutButton = new Button("About Maze");
        aboutButton.setPrefWidth(200);
        aboutButton.setFont(new Font("Cambria", 20));
        aboutButton.setOnAction(e ->
                pcs.firePropertyChange("aboutbutton","v1","v2"));
    }



}
