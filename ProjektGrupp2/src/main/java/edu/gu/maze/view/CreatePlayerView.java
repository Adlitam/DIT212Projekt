package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Johan on 2015-05-18.
 */
public class CreatePlayerView {
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    BorderPane borderPaneLayout;
    private TextField name;
    private ImageView mage;
    private ImageView thief;
    private ImageView warrior;


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
        GridPane setName = new GridPane();
        Label title = new Label("Write Your Name:");
        GridPane.setConstraints(title,0,0);
        name = new TextField();

        name.setMinWidth(400);
        GridPane.setConstraints(name,0,1);
        setName.getChildren().addAll(title, name);
        setName.setAlignment(Pos.CENTER);
        borderPaneLayout.setTop(setName);

    }

    private void createMiddle(){
        HBox chooseCharacter = new HBox();
        chooseCharacter.getChildren().addAll(getMageNode(),getWarriorNode(),getThiefNode());
        chooseCharacter.setAlignment(Pos.CENTER);
        chooseCharacter.setSpacing(20);
        borderPaneLayout.setCenter(chooseCharacter);

    }


    private ImageView getMageNode(){
        Image image = new Image("Mage.png");
        mage = new ImageView();
        mage.setImage(image);
        mage.setFitHeight(200);
        mage.setFitWidth(200);
        mage.setOnMouseClicked(e ->  pcs.firePropertyChange("mage", warrior, thief));
        return mage;
    }
    private ImageView getWarriorNode(){
        Image image = new Image("warrior.png");
        warrior = new ImageView();
        warrior.setImage(image);
        warrior.setFitHeight(200);
        warrior.setFitWidth(200);
        warrior.setOnMouseClicked(e -> pcs.firePropertyChange("warrior", mage, thief));
        return warrior;
    }
    private ImageView getThiefNode(){
        Image image = new Image("thief.png");
        thief = new ImageView();
        thief.setImage(image);
        thief.setFitHeight(200);
        thief.setFitWidth(200);
        thief.setOnMouseClicked(e ->
            pcs.firePropertyChange("thief", mage, warrior)
        );
        return thief;
    }

    private void createBottom(){
        HBox playAndReturn = new HBox();

        Button playButton = new Button("Play");
        playButton.setPrefWidth(200);
        playButton.setOnAction(e ->
                        pcs.firePropertyChange("playButton", name, "value2")
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
