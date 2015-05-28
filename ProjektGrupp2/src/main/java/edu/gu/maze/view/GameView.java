package edu.gu.maze.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameView{


    public GameView(Stage s, MapView m, InfoView i1, InputOutputView i2){
        s.setTitle("Maze");
        final BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background: Black");
        final GridPane map = m.getMap();
        final VBox info = i1.getInfoView();
        final VBox inputAndReturnAndOutput = i2.getInputView();
        borderPane.setCenter(map);
        borderPane.setRight(info);
        borderPane.setBottom(inputAndReturnAndOutput);
        final Scene gameScene = new Scene(borderPane, 800, 620);
        s.setScene(gameScene);
    }


}