package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Matildaandersson on 15-05-19.
 */
public class StartView {

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    Button slot1;
    Button slot2;
    Button slot3;
    Button playButton;
    BorderPane layout;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }


    public StartView(Stage stage){
        stage.setTitle("Maze");

        layout = new BorderPane();

        createBottom();
        createPane();

        Scene startScene = new Scene(layout,800,600);
        stage.setScene(startScene);
    }


    public void createPane(){


        slot1 = new Button("Slot1");
        slot2 = new Button("Slot2");
        slot3 = new Button("Slot3");

        slot1.setOnAction(e -> pcs.firePropertyChange("Create","v1","v2"));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(slot1,slot2,slot3);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        layout.setCenter(vBox);




    }


    private void createBottom(){
        HBox hBoxBotton = new HBox();

        Button playButton = new Button("Play");
        playButton.setPrefWidth(200);
        playButton.setOnAction(e ->
                        pcs.firePropertyChange("playButton", "value1", "value2")
        );

        Button backButton = new Button("Back to start");
        backButton.setPrefWidth(200);
        backButton.setOnAction(e ->
                        pcs.firePropertyChange("backButtonH", "value1", "value2")
        );

        hBoxBotton.getChildren().addAll(playButton, backButton);
        hBoxBotton.setAlignment(Pos.CENTER);
        hBoxBotton.setSpacing(10);

        layout.setBottom(hBoxBotton);


    }



}
