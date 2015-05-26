package edu.gu.maze.view;

import edu.gu.maze.controller.SelectMapController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectMapView {
    private Button backButton;
    private Button map1;
    private Button map2;
    private Button map3;
    private BorderPane layout;
    private HBox hBox1 = new HBox();
    private HBox hBox2 = new HBox();
    private HBox hBox3 = new HBox();

    public SelectMapView(Stage stage){
        stage.setTitle("Maze");

        layout = new BorderPane();

        createBottom();
        createPane();

        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        Scene startScene = new Scene(layout,800,600);
        stage.setScene(startScene);

    }


    private void createPane(){



        Label playerName1 = new Label("Map 1");
        Label playerName2 = new Label("Map 2");
        Label playerName3 = new Label("Map 3");

        //First slot
        map1 = new Button();
        map1.setMinSize(100,100);
        hBox1.getChildren().addAll(map1,playerName1);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);

        //Second slot
        map2 = new Button();
        map2.setMinSize(100,100);
        hBox2.getChildren().addAll(map2,playerName2);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);

        //Slot 3
        map3 = new Button();
        map3.setMinSize(100,150);
        hBox3.getChildren().addAll(map3,playerName3);
        hBox3.setSpacing(10);
        hBox3.setAlignment(Pos.CENTER);



        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1,hBox2,hBox3);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        layout.setCenter(vBox);


    }



    private void createBottom(){
        HBox hBoxBotton = new HBox();


        backButton = new Button("Back to start");
        backButton.setPrefWidth(200);


        hBoxBotton.getChildren().addAll(backButton);
        hBoxBotton.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxBotton.setSpacing(10);

        layout.setBottom(hBoxBotton);


    }

    public void addController(SelectMapController c){
        backButton.setOnAction(c);
        map1.setOnAction(c);
        map2.setOnAction(c);
        map3.setOnAction(c);
    }

    public Button getBackButton(){
        return backButton;
    }

    public Button getMap1(){
        return map1;
    }

    public Button getMap2(){
        return map2;
    }

    public Button getMap3(){
        return map3;
    }
}
