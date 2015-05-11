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
    private TextField input= new TextField();
    private Rectangle2D screenSize;
    private Button backButton;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }


    public InputView() {
        inputAndReturn = new HBox();

        screenSize = Screen.getPrimary().getVisualBounds();
        input.setPrefWidth(screenSize.getWidth() - 100);
        input.setOnKeyPressed(e1 -> {
            switch (e1.getCode()) {
                case ENTER:
                    pcs.firePropertyChange("Input", input, "value2");

                    break;
            }
        });
        backButton = new Button("Back to start");
        backButton.setMinWidth(100);
        backButton.setOnAction(e2 -> {
            pcs.firePropertyChange("backButtonG", "value1", "value2");
        });
        inputAndReturn.getChildren().addAll(input, backButton);
    }

    public HBox getInputView(){
        return inputAndReturn;
    }



}