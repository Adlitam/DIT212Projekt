package edu.gu.maze.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputOutputView {
    private VBox inputAndReturnAndOutput;
    private TextField input;
    private TextArea output;
    private Rectangle2D screenSize;
    private Button backButton;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }




    public InputOutputView() {
        HBox inputAndReturn = new HBox();
        inputAndReturnAndOutput = new VBox();
        screenSize = Screen.getPrimary().getVisualBounds();
        inputArea();
        backButton();
        outputArea();
        inputAndReturn.getChildren().addAll(input,backButton);
        inputAndReturnAndOutput.getChildren().addAll(output,inputAndReturn);
    }

    private void inputArea(){
        input = new TextField();
        input.setPrefWidth(screenSize.getWidth() - 100);
        input.setOnKeyPressed(e1 -> {
            switch (e1.getCode()) {
                case ENTER:
                    pcs.firePropertyChange("Input", input, "value2");

                    break;
            }
        });
    }

    private void backButton(){
        backButton = new Button("Back to start");
        backButton.setMinWidth(100);
        backButton.setOnAction(e2 -> pcs.firePropertyChange("backButtonG", "value1", "value2"));

    }

    private void outputArea(){
        output = new TextArea();
        output.setPrefSize(screenSize.getWidth(),90);
        output.setEditable(false);
        output.setWrapText(true);
    }



    public VBox getInputView(){
        return inputAndReturnAndOutput;
    }

}