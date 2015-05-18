package edu.gu.maze.view;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by xiang-yu on 2015-05-10.
 */
public class GameView{
    public GameView(Stage s, MapView1 m, InfoView i1, InputOutputView i2){
        s.setTitle("Maze");
        BorderPane borderPane = new BorderPane();
        GridPane map = m.getMap();
        VBox info = i1.getInfoView();
        VBox inputAndReturnAndOutput = i2.getInputView();
        borderPane.setCenter(map);
        borderPane.setRight(info);
        borderPane.setBottom(inputAndReturnAndOutput);
        Scene gameScene = new Scene(borderPane, 1000, 600);
        s.setScene(gameScene);
    }
}