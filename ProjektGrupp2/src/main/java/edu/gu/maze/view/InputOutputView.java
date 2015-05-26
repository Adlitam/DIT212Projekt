package edu.gu.maze.view;

import edu.gu.maze.controller.InputOutputViewController;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InputOutputView implements PropertyChangeListener {
    private VBox inputAndReturnAndOutput;
    private TextArea output;
    private Rectangle2D screenSize;
    private Button backButton;

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
    }

    private void outputArea(){
        output = new TextArea();
        output.setPrefSize(screenSize.getWidth(),90);
        output.setEditable(false);
        output.setWrapText(true);
        output.requestFocus();
        Platform.runLater(output::requestFocus);
    }

    public VBox getInputView(){
        return inputAndReturnAndOutput;
    }

    public void addController(InputOutputViewController c){
        backButton.setOnAction(c);
        output.setOnKeyPressed(c.getKec());
    }

    public Button getBackButton(){
        return backButton;
    }

    public TextArea getOutput(){
        return output;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "NO_FINAL_KEY":
                output.setText("You do not have a final door key!");
                break;
            case "NO_KEY":
                output.setText("You do not have a door key!");
                break;
            case "NO_APPLE":
                output.setText("You do not have any apples!");
                break;
            case "KEY":
                output.setText("You opened the door with a key!");
                break;
            case "APPLE":
                output.setText("You gave the monster an apple!");
                break;
            case "QUESTION":
                String question = (String) evt.getOldValue();
                String[] answers = (String[]) evt.getNewValue();
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "YES":
                output.clear();
                break;
        }
    }
}