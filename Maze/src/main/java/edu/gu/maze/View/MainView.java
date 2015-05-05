package edu.gu.maze.View;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;




import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.util.Observable;

/**
 * Created by xiang-yu on 2015-05-03.
 */
public class MainView extends Observable{
    Stage stage;
    private Scene mainScene, gameScene, highScoreScene;
    private VBox vBoxlayout;
    private BorderPane borderPaneLayout;
    private Button playButton, highScoreButton;
    private boolean playButtonPressed;
    private boolean BackButtonPressed;
    private boolean HighScoreButtonPressed;

    public MainView(Stage primaryStage){
        stage = primaryStage;
        stage.setTitle("Maze");
        playButton = new Button("Play the game");
        playButton.setOnAction(e -> {
            playButtonPressed = true;
            setChanged();
            notifyObservers();
        });
        highScoreButton = new Button("High Score");
        highScoreButton.setOnAction(e -> {
            HighScoreButtonPressed = true;
            setChanged();
            notifyObservers();
        });
        vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(playButton,highScoreButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        mainScene = new Scene(vBoxlayout, 1000, 600);
        stage.setScene(mainScene);
        stage.show();
    }

    public boolean getPlayButtonPressed(){
        return playButtonPressed;
    }
    public boolean getBackButtonPressed(){
        return BackButtonPressed;
    }
    public boolean getHighScoreButtonPressed(){
        return HighScoreButtonPressed;
    }
    public void setPlayButtonFalse(){
        playButtonPressed = false;
    }
    public void setBackButtonFalse(){
        BackButtonPressed = false;
    }
    public void setHighScoreButtonFalse(){
        HighScoreButtonPressed = false;
    }

    public void changeToGameScene(){
        BorderPane borderPane = new BorderPane();
        VBox bottom = new VBox();
        TextArea output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);
        HBox inputAndBack = new HBox();
        TextField input = new TextField();
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        input.setPrefWidth(screenSize.getWidth() - 100);
        Button backButton = new Button("Back to start");
        backButton.setOnAction(e -> {
            BackButtonPressed = true;
            setChanged();
            notifyObservers();
        });
        backButton.setMinWidth(100);
        inputAndBack.getChildren().addAll(input,backButton);
        bottom.setPrefSize(screenSize.getWidth(), 100);
        bottom.getChildren().addAll(output, inputAndBack);

        // The planel on the right
        VBox right = new VBox();

        //The label with how many apples the player have
        Label apple = new Label("Apple");
        apple.setAlignment(Pos.CENTER);
        apple.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        apple.setStyle("-fx-border-color: black;");

        //The label with how many keys the player have
        Label key = new Label("Key");
        key.setAlignment(Pos.CENTER);
        key.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        key.setStyle("-fx-border-color: black;");

        VBox points = new VBox();
        Label text = new Label("Score");

        Label score = new Label();
        score.setText("placeholder");

        points.getChildren().addAll(text, score);
        points.setAlignment(Pos.CENTER);
        points.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        points.setStyle("-fx-border-color: black;");

        Label time = new Label("Time");
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        time.setStyle("-fx-border-color: black;");

        right.getChildren().addAll(apple, key, points, time);
        right.minWidth(100);
        right.setMinWidth(100);



        borderPane.setBottom(bottom);
        borderPane.setRight(right);

        gameScene = new Scene(borderPane, 1000, 600);
        stage.setScene(gameScene);
    }

    public void changeToStartScene(){
        vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(playButton,highScoreButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        mainScene = new Scene(vBoxlayout, 1000, 600);
        stage.setScene(mainScene);
    }

    public void changeToHighScoreScene(){
        borderPaneLayout = new BorderPane();
        highScoreScene = new Scene(borderPaneLayout, 1000, 600);
        stage.setScene(highScoreScene);
    }
}

