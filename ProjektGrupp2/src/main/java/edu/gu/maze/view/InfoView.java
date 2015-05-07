package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Johan on 2015-05-07.
 */
public class InfoView {

    // The planel on the right
    public VBox createInfoPanel(Rectangle2D screenSize) {
    VBox right = new VBox();

    Label apple = apple(screenSize);
    Label key = key(screenSize);
    VBox points = points(screenSize);
    Label time = time(screenSize);

    right.getChildren().addAll(apple, key, points, time);
    right.minWidth(100);
    right.setMinWidth(100);

        return right;
    }

    //The label that show the current amount of apples that the player has
    private Label apple(Rectangle2D screenSize){
        Label apple = new Label("Apple");
        apple.setAlignment(Pos.CENTER);
        apple.setPrefSize(100,(screenSize.getHeight()-100)/4);
        apple.setStyle("-fx-border-color: black;");
        return apple;
    }
    //The label that show the current amount of keys that the player has
    private Label key(Rectangle2D screenSize){
        Label key = new Label("Key");
        key.setAlignment(Pos.CENTER);
        key.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        key.setStyle("-fx-border-color: black;");

        return key;
    }
    // The label that show the current score
    private VBox points(Rectangle2D screenSize){
        VBox points = new VBox();
        Label text = new Label("Score");

        Label score = new Label();
        score.setText("placeholder");

        points.getChildren().addAll(text, score);

        points.setAlignment(Pos.CENTER);
        points.setPrefSize(100,(screenSize.getHeight()-100)/4);
        points.setStyle("-fx-border-color: black;");

        return points;
    }
    //The Time label that show the current time
    private Label time(Rectangle2D screenSize){
        Label time = new Label("Time");
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100,(screenSize.getHeight()-100)/4);
        time.setStyle("-fx-border-color: black;");

        return time;
    }

}
