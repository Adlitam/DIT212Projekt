package edu.gu.maze.view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainView{

    private Button playButton;
    private Button highScoreButton;
    private Button aboutButton;


    public MainView(Stage primaryStage){
        final BorderPane layout;
        primaryStage.setTitle("Maze");
        layout = new BorderPane();
        final HBox top = new HBox();
        final Label titel = new Label("Maze");
        titel.setFont(new Font(40));
        top.getChildren().addAll(titel);
        top.setAlignment(Pos.CENTER);
        layout.setTop(top);

        createPlayButton();
        createHighScoreButton();
        createAboutButton();

        final VBox vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(playButton,highScoreButton,aboutButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        vBoxlayout.setSpacing(50);

        layout.setCenter(vBoxlayout);
        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");
        final Scene mainScene = new Scene(layout, 800, 600);
        //stage.setResizable(false);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    private final void createPlayButton(){
        //Creates the PlayButton
        playButton = new Button("Play");
        playButton.setPrefWidth(200);
        playButton.setFont(new Font("Cambria", 20));
    }

    private final void createHighScoreButton(){
        //Creates the highscoreButton
        highScoreButton = new Button("High Score");
        highScoreButton.setPrefWidth(200);
        highScoreButton.setFont(new Font("Cambria", 20));
    }

    private final void createAboutButton(){
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
