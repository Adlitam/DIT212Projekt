package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Johan on 2015-05-18.
 */
public class CreatePlayerView {
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    BorderPane borderPaneLayout;
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public CreatePlayerView(Stage stage){
        stage.setTitle("Maze");
        borderPaneLayout = new BorderPane();
        createTop();
        createMiddle();
        createBottom();
        Scene highScoreScene = new Scene(borderPaneLayout, 800, 600);

        stage.setScene(highScoreScene);
    }


    private void createTop(){
        VBox setName = new VBox();
        Label title = new Label("Your Name");
        TextField name = new TextField();
        name.setMaxWidth(400);
        setName.getChildren().addAll(title, name);
        setName.setAlignment(Pos.CENTER);
        borderPaneLayout.setTop(setName);
    }

    private void createMiddle(){
    }

    private void createBottom(){
        HBox playAndReturn = new HBox();

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

        playAndReturn.getChildren().addAll(playButton, backButton);
        playAndReturn.setAlignment(Pos.CENTER);
        playAndReturn.setSpacing(10);



        borderPaneLayout.setBottom(playAndReturn);
    }


}
