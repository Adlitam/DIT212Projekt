package edu.gu.maze.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InputOutputView{
    private VBox inputAndReturnAndOutput;

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
        backButton();
        outputArea();
        inputAndReturn.getChildren().addAll(backButton);
        inputAndReturn.setAlignment(Pos.BOTTOM_RIGHT);
        inputAndReturnAndOutput.getChildren().addAll(output, inputAndReturn);
    }

    private void backButton(){
        backButton = new Button("Back to start");
        backButton.setMinWidth(100);
        backButton.setOnAction(e2 ->
                pcs.firePropertyChange("backButtonG", "value1", "value2"));
    }

    private void outputArea(){
        output = new TextArea();
        output.setPrefSize(screenSize.getWidth(),90);
        output.setEditable(false);
        output.setWrapText(true);
        output.requestFocus();
        Platform.runLater(output::requestFocus);
        output.setOnKeyPressed(e2 -> {
            switch (e2.getCode()) {
                case UP:
                    pcs.firePropertyChange("UP", output, "v2");
                    e2.consume();
                    break;
                case DOWN:
                    pcs.firePropertyChange("DOWN", output, "v2");
                    e2.consume();
                    break;
                case LEFT:
                    pcs.firePropertyChange("LEFT", output, "v2");
                    e2.consume();
                    break;
                case RIGHT:
                    pcs.firePropertyChange("RIGHT", output, "v2");
                    e2.consume();
                    break;
                case A:
                    pcs.firePropertyChange("Answer A", output, "v2");
                    e2.consume();
                    break;
                case S:
                    pcs.firePropertyChange("Answer S", output, "v2");
                    e2.consume();
                    break;
                case D:
                    pcs.firePropertyChange("Answer D", output, "v2");
                    e2.consume();
                    break;
            }
        });
    }



    public VBox getInputView(){
        return inputAndReturnAndOutput;
    }

}