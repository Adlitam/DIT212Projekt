package edu.gu.maze.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by xiang-yu on 2015-05-10.
 */
public class GameView{
    private Stage stage;
    private MapView1 mapView1;
    private InfoView infoView;
    private InputOutputView inputView;


    private BorderPane borderPane;
    private VBox inputAndReturnAndOutput;
    private Rectangle2D screenSize;
    private TextArea output;
    private GridPane map;
    private VBox info;
    private Scene gameScene;

    public GameView(Stage s, MapView1 m, InfoView i1, InputOutputView i2){
        stage = s;
        stage.setTitle("Maze");
        mapView1 = m;
        infoView = i1;
        inputView = i2;


        screenSize = Screen.getPrimary().getVisualBounds();
        borderPane = new BorderPane();
        inputAndReturnAndOutput = inputView.getInputView();
        map = mapView1.getMap();
        info = infoView.getInfoView();
        borderPane.setCenter(map);
        borderPane.setRight(info);
        borderPane.setBottom(inputAndReturnAndOutput);
        gameScene = new Scene(borderPane, 1000, 600);
        stage.setScene(gameScene);
    }
}