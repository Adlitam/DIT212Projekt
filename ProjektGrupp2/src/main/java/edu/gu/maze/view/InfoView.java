package edu.gu.maze.view;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


/**
 * Created by Johan on 2015-05-07.
 */
public class InfoView {
    private Rectangle2D screenSize;
    private VBox right;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public InfoView(){
        screenSize = Screen.getPrimary().getVisualBounds();
        right = new VBox();
        Label apple = getAppleLabel();
        Label key = getKeyLabel();
        VBox points = getPointsVBox();
        Label time = getTimeLabel();
        right.getChildren().addAll(apple, key, points, time);
        right.minWidth(100);
        right.setMinWidth(100);
    }

    // The planel on the right
    public VBox getInfoView(){
        return right;
    }

    //The label that show the current amount of apples that the player has
    private Label getAppleLabel(){
        Label apple = new Label("Apples:");
        apple.setAlignment(Pos.CENTER);
        apple.setPrefSize(100,(screenSize.getHeight()-100)/4);
        apple.setStyle("-fx-border-color: black;");
        return apple;
    }
    //The label that show the current amount of keys that the player has
    private Label getKeyLabel(){
        Label key = new Label("Keys:");
        key.setAlignment(Pos.CENTER);
        key.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        key.setStyle("-fx-border-color: black;");
        return key;
    }
    // The label that show the current score
    private VBox getPointsVBox(){
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
    private Label getTimeLabel(){
        Label time = new Label();
        //new InfoController().timeController(time);   //what is this? View shouldn't know about the controller
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100,(screenSize.getHeight()-100)/4);
        time.setStyle("-fx-border-color: black;");
        return time;
    }
}
