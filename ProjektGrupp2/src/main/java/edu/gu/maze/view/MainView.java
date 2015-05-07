package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
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
    private HBox hBoxlayout;
    private BorderPane borderPaneLayout;
    private Button playButton, highScoreButton;
    private Button backButton = new Button("Back to start");
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
        HBox inputAndBack = new HBox();

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        backButton.setOnAction(e -> {
            BackButtonPressed = true;
            setChanged();
            notifyObservers();
        });
        backButton.setMinWidth(100);
        // The input View
        InputView input = new InputView();
        inputAndBack.getChildren().addAll(input.createInput(screenSize), backButton);
        bottom.setPrefSize(screenSize.getWidth(), 100);
        // The output View
        OutputView output = new OutputView();
        bottom.getChildren().addAll(output.createOutput(), inputAndBack);


        MapView map = new MapView();

        Pane testPane = map.createMap1();
        borderPane.setCenter(testPane);
        borderPane.setBottom(bottom);
        //The info View
        InfoView info = new InfoView();
        borderPane.setRight(info.createInfoPanel(screenSize));

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
        hBoxlayout = new HBox();
        hBoxlayout.getChildren().add(backButton);
        hBoxlayout.setAlignment(Pos.CENTER);
        backButton.setOnAction(e -> {
            BackButtonPressed = true;
            setChanged();
            notifyObservers();
        });
        borderPaneLayout.setBottom(hBoxlayout);
        highScoreScene = new Scene(borderPaneLayout, 1000, 600);
        stage.setScene(highScoreScene);
    }
}
