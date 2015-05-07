package edu.gu.maze.view;

import edu.gu.maze.controller.InputController;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextField;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputView {
    private TextField input = new TextField();
    public TextField createInput(Rectangle2D screenSize) {

        input.setPrefWidth(screenSize.getWidth() - 100);
        new InputController().getInput(input);
        return input;
    }


}
