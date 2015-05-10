package edu.gu.maze.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputView {
    private HBox inputAndReturn;
    private TextField input;
    private Rectangle2D screenSize;
    private Button backButton;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public InputView(){
        inputAndReturn = new HBox();
        input = new TextField();
        screenSize = Screen.getPrimary().getVisualBounds();
        input.setPrefWidth(screenSize.getWidth() - 100);
        backButton = new Button("Back to start");
        backButton.setMinWidth(100);
        backButton.setOnAction(e -> {
            pcs.firePropertyChange("backButtonG", "value1", "value2");
        });
        inputAndReturn.getChildren().addAll(input, backButton);
    }

    public HBox getInputView(){
        return inputAndReturn;
    }



    public TextField createInput(Rectangle2D screenSize) {
        input.setPrefWidth(screenSize.getWidth() - 100);
        //new InputController().getInput(input);   //what is this? View shouldn't know about the controller
        return input;
    }
}