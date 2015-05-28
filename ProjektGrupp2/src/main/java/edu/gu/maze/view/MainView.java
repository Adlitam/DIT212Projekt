package edu.gu.maze.view;

import edu.gu.maze.controller.MainController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainView{
    private Stage stage;
    private Button playButton;
    private Button highScoreButton;
    private Button aboutButton;
    private BorderPane layout;

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
        vBoxlayout.getChildren().addAll(playButton,highScoreButton,aboutButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        vBoxlayout.setSpacing(50);

        layout.setCenter(vBoxlayout);
        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");
        Scene mainScene = new Scene(layout, 800, 600);
        //stage.setResizable(false);
        stage.setScene(mainScene);
        stage.show();
    }

    private void createPlayButton(){
        //Creates the PlayButton
        playButton = new Button("Play");
        playButton.setPrefWidth(200);
        playButton.setFont(new Font("Cambria", 20));
    }

    private void createHighScoreButton(){
        //Creates the highscoreButton
        highScoreButton = new Button("High Score");
        highScoreButton.setPrefWidth(200);
        highScoreButton.setFont(new Font("Cambria", 20));
    }

    private void createAboutButton(){
        //Creats the About button
        aboutButton = new Button("About Maze");
        aboutButton.setPrefWidth(200);
        aboutButton.setFont(new Font("Cambria", 20));
    }

    public Button getPlayButton(){
        return playButton;
    }

    public Button getHighScoreButton(){
        return highScoreButton;
    }

    public Button getAboutButton(){
        return aboutButton;
    }
}
