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
    private IGame model;
    private Stage stage;
    private InputOutputView view;
    private KeyEventController kec;

    public InputOutputViewController(IGame model, InputOutputView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        kec = new KeyEventController();
        this.view.addController(this);
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

    @Override
    public void handle(ActionEvent event) {
        Object b = event.getSource();
        if(b == view.getBackButton()){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage);
        }
    }

    public KeyEventController getKec(){
        return kec;
    }

    // Check if it is the right answer
    private void checkAnswer(int i){
        TextArea output = view.getOutput();
        try {
            if (model.isThisTheRightAnswer(i) == 1) {
                output.setText("Correct answer!! \nYou earned: \n5 Points \n1 Key \n1 Apple");
            } else {
                output.setText("Wrong answer!! \nYou lost 5 points");
            }
        }catch(NullPointerException e){
            System.out.println("You gave an answer without any question");
        }
    }
}
