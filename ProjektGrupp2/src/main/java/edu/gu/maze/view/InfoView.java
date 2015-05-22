package edu.gu.maze.view;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InfoView {
    private Rectangle2D screenSize;
    private VBox right;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    // Put together all Nodes in the VBox
    public InfoView(){
        screenSize = Screen.getPrimary().getVisualBounds();
        right = new VBox();
        right.getChildren().addAll(getAppleNode(), getKeyNode(), getPointsNode(), getTimeNode());
        right.minWidth(100);
        right.setMinWidth(100);

    }

    // The planel on the right
    public VBox getInfoView(){
        return right;
    }

    // The label that show the current amount of apples that the player has
    private VBox getAppleNode(){
        VBox appleBox = new VBox();

        Image image = new Image("apple.png");
        ImageView apple = new ImageView();
        apple.setImage(image);
        apple.setFitHeight(75);
        apple.setFitWidth(75);

        Label nrApples = new Label();
        nrApples.setFont(new Font(20));
        updateLabels(nrApples,"apples");
        appleBox.getChildren().addAll(apple,nrApples);
        appleBox.setPrefSize(100,(screenSize.getHeight()-100)/4);
        appleBox.setStyle("-fx-border-color: white;");
        appleBox.setAlignment(Pos.CENTER);
        return appleBox;
    }
    // The label that show the current amount of keys that the player has
    private VBox getKeyNode(){
        VBox keyBox = new VBox();

        Image image = new Image("key.png");
        ImageView key = new ImageView();
        key.setImage(image);
        key.setFitHeight(75);
        key.setFitWidth(75);

        Label nrKeys = new Label();
        nrKeys.setFont(new Font(20));
        updateLabels(nrKeys, "keys");
        keyBox.getChildren().addAll(key,nrKeys);
        keyBox.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        keyBox.setStyle("-fx-border-color: white;");
        keyBox.setAlignment(Pos.CENTER);
        return keyBox;
    }
    // The label that show the current score
    private VBox getPointsNode(){
        VBox points = new VBox();
        Label text = new Label("Score");

        Label score = new Label();
        score.setFont(new Font(20));
        updateLabels(score,"points");

        points.getChildren().addAll(text, score);

        points.setAlignment(Pos.CENTER);
        points.setPrefSize(100, (screenSize.getHeight()-100)/4);
        points.setStyle("-fx-border-color: white;");

        return points;
    }

    //The Time label that show the current time
    private Label getTimeNode(){
        Label time = new Label();
        time.setFont(new Font(20));
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100,(screenSize.getHeight()-100)/4);
        time.setStyle("-fx-border-color: white;");

        updateLabels(time,"timer");

        return time;
    }
    // Sends away a firePropertyChange 60 times/sec that includes the name and the label
    private void updateLabels(Label l, String s){
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                pcs.firePropertyChange(s, l, "v2");
            }
        };
        animationTimer.start();
    }
}

