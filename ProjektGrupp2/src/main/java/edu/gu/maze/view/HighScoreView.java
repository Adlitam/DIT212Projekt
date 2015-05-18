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
 * Created by xiang-yu on 2015-05-10.
 */
public class HighScoreView{
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public HighScoreView(Stage stage){
        stage.setTitle("Maze");
        BorderPane borderPaneLayout = new BorderPane();
        HBox hBoxlayout = new HBox();
        Button backButton = new Button("Back to start");
        hBoxlayout.getChildren().add(backButton);
        hBoxlayout.setAlignment(Pos.CENTER);
        backButton.setOnAction(e ->
                pcs.firePropertyChange("backButtonH", "value1", "value2"));
        borderPaneLayout.setBottom(hBoxlayout);
        Scene highScoreScene = new Scene(borderPaneLayout, 1000, 600);
        stage.setScene(highScoreScene);
    }
}
