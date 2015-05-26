package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class InfoView {
    private Rectangle2D screenSize;
    private VBox right;
    private Label time;
    private Label score;
    private Label nrKeys;
    private Label nrApples;

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
        nrApples = new Label();
        nrApples.setFont(new Font(20));
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
        nrKeys = new Label();
        nrKeys.setFont(new Font(20));
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
        score = new Label();
        score.setFont(new Font(20));
        points.getChildren().addAll(text, score);
        points.setAlignment(Pos.CENTER);
        points.setPrefSize(100, (screenSize.getHeight()-100)/4);
        points.setStyle("-fx-border-color: white;");
        return points;
    }

    //The Time label that show the current time
    private Label getTimeNode(){
        time = new Label();
        time.setFont(new Font(20));
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100,(screenSize.getHeight()-100)/4);
        time.setStyle("-fx-border-color: white;");
        return time;
    }

    public Label getTime(){
        return time;
    }

    public Label getText(){
        return score;
    }

    public Label getNrKeys(){
        return nrKeys;
    }

    public Label getNrApples(){
        return nrApples;
    }
}

