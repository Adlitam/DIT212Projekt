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


    /*public void changeToGameScene(){
        BorderPane borderPane = new BorderPane();
        VBox bottom = new VBox();
        HBox inputAndBack = new HBox();

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        backButton.setOnAction(e -> {
            BackButtonPressed = true;
            //setChanged();
            //notifyObservers();
        });
        backButton.setMinWidth(100);

        // The input View
        InputView input = new InputView();
        inputAndBack.getChildren().addAll(input.createInput(screenSize), backButton);
        bottom.setPrefSize(screenSize.getWidth(), 100);
        // The output View
        OutputView output = new OutputView();
        bottom.getChildren().addAll(output.createOutput(), inputAndBack);


        MapView1 map = new MapView1();

        Pane testPane = map.createMap1();
        borderPane.setCenter(testPane);
        borderPane.setBottom(bottom);
        //The info View
        InfoView info = new InfoView();

        //borderPane.setRight(info.createInfoPanel(screenSize));



        gameScene = new Scene(borderPane, 1000, 600);
        stage.setScene(gameScene);

    }*/

    /*public void changeToStartScene(){
        vBoxlayout = new VBox();
        vBoxlayout.getChildren().addAll(playButton,highScoreButton);
        vBoxlayout.setAlignment(Pos.CENTER);
        mainScene = new Scene(vBoxlayout, 1000, 600);
        stage.setScene(mainScene);
    }*/

    /*public void changeToHighScoreScene(){
        borderPaneLayout = new BorderPane();
        hBoxlayout = new HBox();
        hBoxlayout.getChildren().add(backButton);
        hBoxlayout.setAlignment(Pos.CENTER);
        backButton.setOnAction(e -> {
            BackButtonPressed = true;
            //setChanged();
            //notifyObservers();
        });
        borderPaneLayout.setBottom(hBoxlayout);
        highScoreScene = new Scene(borderPaneLayout, 1000, 600);
        stage.setScene(highScoreScene);
    }*/
}
