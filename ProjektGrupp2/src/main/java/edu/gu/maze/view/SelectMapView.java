package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Matildaandersson on 15-05-20.
 */
public class SelectMapView {

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    Button map1;
    Button map2;
    Button map3;
    BorderPane layout;
    HBox hBox1 = new HBox();
    HBox hBox2 = new HBox();
    HBox hBox3 = new HBox();

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }


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
        map1.setOnAction(e -> pcs.firePropertyChange("Map1","v1","v2"));

        //Second slot
        map2 = new Button();
        map2.setMinSize(100,100);
        hBox2.getChildren().addAll(map2,playerName2);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);
        map2.setOnAction(e -> pcs.firePropertyChange("Map1","v1","v2"));

        //Slot 3
        map3 = new Button();
        map3.setMinSize(100,150);
        hBox3.getChildren().addAll(map3,playerName3);
        hBox3.setSpacing(10);
        hBox3.setAlignment(Pos.CENTER);
        map3.setOnAction(e -> pcs.firePropertyChange("Map1","v1","v2"));



        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1,hBox2,hBox3);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        layout.setCenter(vBox);


    }



    private void createBottom(){
        HBox hBoxBotton = new HBox();


        Button backButton = new Button("Back to start");
        backButton.setPrefWidth(200);
        backButton.setOnAction(e ->
                        pcs.firePropertyChange("backButtonH", "value1", "value2")
        );

        hBoxBotton.getChildren().addAll(backButton);
        hBoxBotton.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxBotton.setSpacing(10);

        layout.setBottom(hBoxBotton);


    }

}
