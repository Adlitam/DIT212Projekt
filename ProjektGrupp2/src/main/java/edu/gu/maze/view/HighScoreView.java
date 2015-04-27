package edu.gu.maze.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;

/**
 * Created by Matildaandersson on 15-04-27.
 */
public class HighScoreView {




    public Scene highScore (Scene hsScene){

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

        //Layout
        BorderPane layout = new BorderPane();

        hsScene = new Scene(layout,screenSize.getWidth(), screenSize.getHeight());

        return hsScene;
    }


}
