package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Matildaandersson on 15-05-20.
 */
public class CongratzView {
    BorderPane layout;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public CongratzView(Stage stage){

        stage.setTitle("Maze");

        layout = new BorderPane();

        createBottom();
        createPane();

        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        Scene startScene = new Scene(layout,800,600);
        stage.setScene(startScene);

    }

    private void createBottom(){

        Button nextMap = new Button("Next Map");
        nextMap.setPrefWidth(200);
        nextMap.setOnAction(e ->
                        pcs.firePropertyChange("NextMap","v1","v2"));

        Button backButton = new Button("Back to start");
        backButton.setPrefWidth(200);
        backButton.setOnAction(e ->
                        pcs.firePropertyChange("backButtonH", "value1", "value2")
        );

        HBox bottom = new HBox();

        bottom.getChildren().addAll(backButton,nextMap);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(20);




    }

    private void createPane(){

    }



}
