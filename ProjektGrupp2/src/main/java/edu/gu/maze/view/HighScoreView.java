package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class HighScoreView{
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    BorderPane borderPaneLayout;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public HighScoreView(Stage stage){
        stage.setTitle("Maze");
        borderPaneLayout = new BorderPane();

        //Create the layout
        createList();
        createTop();
        createBackButton();


        borderPaneLayout.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        //Sets the scene
        Scene highScoreScene = new Scene(borderPaneLayout, 800, 620);
        stage.setScene(highScoreScene);
    }


    public void createList(){
        //Add three labels
        Label player1 = new Label("Player 1");
        player1.setFont(new Font(20));
        Label player2 = new Label("Player 2");
        player2.setFont(new Font(20));
        Label player3 = new Label("Player 3");
        player3.setFont(new Font(20));

        Label score1 = new Label("Score1");
        score1.setFont(new Font(20));
        Label score2 = new Label("Score2");
        score2.setFont(new Font(20));
        Label score3 = new Label("Score3");
        score3.setFont(new Font(20));


        HBox highScore1 = new HBox();
        highScore1.getChildren().addAll(player1,score1);
        highScore1.setSpacing(100);
        highScore1.setAlignment(Pos.CENTER);
        highScore1.setStyle("-fx-border-color: Black");
        HBox highScore2 = new HBox();
        highScore2.getChildren().addAll(player2,score2);
        highScore2.setSpacing(100);
        highScore2.setAlignment(Pos.CENTER);
        highScore2.setStyle("-fx-border-color: Black");
        HBox highScore3 = new HBox();
        highScore3.getChildren().addAll(player3,score3);
        highScore3.setSpacing(100);
        highScore3.setAlignment(Pos.CENTER);
        highScore3.setStyle("-fx-border-color: Black");



        VBox vBoxCenter = new VBox();
        //Added the labels to the HBox
        vBoxCenter.getChildren().addAll(highScore1,highScore2,highScore3);
        vBoxCenter.setAlignment(Pos.CENTER);
        vBoxCenter.setSpacing(100);
        vBoxCenter.setStyle("-fx-border-color: Black");
        //Added the hBox to the layout.
        borderPaneLayout.setCenter(vBoxCenter);


    }


    public void createTop(){

        //The title and the font
        Label title = new Label("High Score");
        title.setFont(new Font("Cambria", 40));

        HBox hBoxTop = new HBox();
        hBoxTop.getChildren().addAll(title);
        hBoxTop.setAlignment(Pos.CENTER);

        borderPaneLayout.setTop(hBoxTop);

    }

    public void createBackButton(){

        //Create the backbutton
        HBox hBoxlayout = new HBox();
        Button backButton = new Button("Back to start");
        hBoxlayout.getChildren().add(backButton);
        hBoxlayout.setAlignment(Pos.CENTER);

        //add a propertyChnageListner
        backButton.setOnAction(e ->
                pcs.firePropertyChange("backButtonH", "value1", "value2"));
        borderPaneLayout.setBottom(hBoxlayout);

    }

}
