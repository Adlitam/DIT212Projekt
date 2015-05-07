package edu.gu.maze.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextField;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputView {

    public TextField createInput(Rectangle2D screenSize) {
        TextField input = new TextField();
        input.setPrefWidth(screenSize.getWidth() - 100);
        return input;
    }

}
