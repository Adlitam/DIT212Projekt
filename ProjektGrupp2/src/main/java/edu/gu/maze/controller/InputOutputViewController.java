package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InputOutputView;
import edu.gu.maze.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class InputOutputViewController implements EventHandler<ActionEvent> {
    private final IGame model;
    private final Stage stage;
    private final InputOutputView view;

    public InputOutputViewController(IGame model, InputOutputView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        final KeyEventController kec = new KeyEventController();
        this.view.getBackButton().setOnAction(this);
        this.view.getOutput().setOnKeyPressed(kec);
    }

    //inner class for handling KeyEvents
    private class KeyEventController implements EventHandler<KeyEvent>{
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case UP:
                    model.moveUp();
                    event.consume();
                    break;
                case DOWN:
                    model.moveDown();
                    event.consume();
                    break;
                case LEFT:
                    model.moveLeft();
                    event.consume();
                    break;
                case RIGHT:
                    model.moveRight();
                    event.consume();
                    break;
                case A:
                    checkAnswer(0);
                    event.consume();
                    break;
                case S:
                    checkAnswer(1);
                    event.consume();
                    break;
                case D:
                    checkAnswer(2);
                    event.consume();
                    break;
                default:
            }
        }
    }

    //handle method for when the player presses the back to start button.
    @Override
    public void handle(ActionEvent event) {
        final Object b = event.getSource();
        if(b == view.getBackButton()){
            model.setStopLoops(true);
            final MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
    }

    // Check if it is the right answer
    private void checkAnswer(int i){
        final TextArea output = view.getOutput();
        try {
            if (model.isThisTheRightAnswer(i) == 1) {
                output.setText("Correct answer!! \nYou earned: \n5 Points \n1 Key \n1 Apple");
            } else {
                output.setText("Wrong answer!! \nYou lost 5 points");
            }
        }catch (NullPointerException e){
            System.err.print("You tried to asnwer a question without any questions!");
        }
    }
}