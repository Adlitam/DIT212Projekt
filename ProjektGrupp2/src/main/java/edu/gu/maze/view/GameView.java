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



    public GameView(Stage stage, MapView1 mapView1, InfoView infoView, InputOutputView inputView){
        stage.setTitle("Maze");
        BorderPane borderPane = new BorderPane();
        VBox inputAndReturnAndOutput = inputView.getInputView();
        GridPane map = mapView1.getMap();
        VBox info = infoView.getInfoView();
        borderPane.setCenter(map);
        borderPane.setRight(info);
        borderPane.setBottom(inputAndReturnAndOutput);
        Scene gameScene = new Scene(borderPane, 1000, 600);
        stage.setScene(gameScene);
    }
}