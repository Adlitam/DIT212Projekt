package edu.gu.maze.view;

import edu.gu.maze.controller.InfoController;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Date;

/**
 * Created by Johan on 2015-05-07.
 */
public class InfoView {

    // The planel on the right
    public VBox createInfoPanel(Rectangle2D screenSize) {
        VBox right = new VBox();

        Label apple = getAppleLabel(screenSize);
        Label key = getKeyLabel(screenSize);
        VBox points = getPointsVBox(screenSize);
        Label time = getTimeLabel(screenSize);

        right.getChildren().addAll(apple, key, points, time);
        right.minWidth(100);
        right.setMinWidth(100);
        return right;
    }

    //The label that show the current amount of apples that the player has
    private Label getAppleLabel(Rectangle2D screenSize){
        Label apple = new Label("Apples:");
        apple.setAlignment(Pos.CENTER);
        apple.setPrefSize(100,(screenSize.getHeight()-100)/4);
        apple.setStyle("-fx-border-color: black;");
        return apple;
    }
    //The label that show the current amount of keys that the player has
    private Label getKeyLabel(Rectangle2D screenSize){
        Label key = new Label("Keys:");
        key.setAlignment(Pos.CENTER);
        key.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        key.setStyle("-fx-border-color: black;");
        return key;
    }
    // The label that show the current score
    private VBox getPointsVBox(Rectangle2D screenSize){
        VBox points = new VBox();
        Label text = new Label("Score");

        Label score = new Label();
        score.setText("placeholder");

        points.getChildren().addAll(text, score);

        points.setAlignment(Pos.CENTER);
        points.setPrefSize(100, (screenSize.getHeight()-100)/4);
        points.setStyle("-fx-border-color: black;");

        return points;
    }

    //The Time label that show the current time
    private Label getTimeLabel(Rectangle2D screenSize){
        Label time = new Label();
        new InfoController().timeController(time);
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100,(screenSize.getHeight()-100)/4);
        time.setStyle("-fx-border-color: black;");

        return time;
    }
}
