package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Matildaandersson on 15-05-20.
 */
public class AboutView {

    BorderPane layout;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public AboutView(Stage stage){

        stage.setTitle("Maze");

        layout = new BorderPane();

        Label titel = new Label("About Maze");
        titel.setFont(new Font(40));

        HBox top = new HBox();
        top.getChildren().addAll(titel);
        top.setAlignment(Pos.CENTER);

        layout.setTop(top);

        createCenter();
        createBottom();


        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        Scene startScene = new Scene(layout,800,600);
        stage.setScene(startScene);
    }

    private void createCenter(){


        Label about = new Label("Created by: \n\n Matilda Andersson \n Karin Wibergh \n Johan Ärlebrandt \n Jonathan Johansson");
        about.setStyle("-fx-background-color: white");
        about.setFont(new Font(20));

        layout.setCenter(about);



    }

    private void createBottom(){
        Button backButton = new Button("Back to start");
        backButton.setPrefWidth(200);
        backButton.setOnAction(e ->
                        pcs.firePropertyChange("backButtonH", "value1", "value2")
        );

        HBox bottom = new HBox();

        bottom.getChildren().addAll(backButton);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(20);
        layout.setBottom(bottom);

    }
}
