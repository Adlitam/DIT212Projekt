package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MainView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MapController implements PropertyChangeListener{
    IGame model;
    Stage stage;
    private TextArea output;

    public MapController(IGame model, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "backButtonG":
                MainView mainView = new MainView(stage);
                MainController mainController = new MainController(model, stage);
                mainView.addPropertyChangeListener(mainController);
                break;
            case "UP":
                model.moveUp();
                getQuestionAndAnswers(evt);
                break;
            case "DOWN":
                model.moveDown();
                getQuestionAndAnswers(evt);
                break;
            case "LEFT":
                model.moveLeft();
                getQuestionAndAnswers(evt);
                break;
            case "RIGHT":
                model.moveRight();
                getQuestionAndAnswers(evt);
                break;
            case "Answer A":
                checkAnswer(evt,0);
                break;
            case "Answer S":
                checkAnswer(evt,1);
                break;
            case "Answer D":
                checkAnswer(evt,2);
                break;
            default:


        }
    }
    // get the Answer and print it out in the output field
    private void getQuestionAndAnswers(PropertyChangeEvent evt){
        output = (TextArea) evt.getOldValue();
        String question = model.getQuestion();
        String[] answers = model.getAnswers();
        output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
    }

   // Check if it is the right answer
    private void checkAnswer(PropertyChangeEvent evt, int i){
        output = (TextArea) evt.getOldValue();
        try {
            if (model.isThisTheRightAnswer(i) == 1) {
                output.setText("Correct answer!!");
            } else {
                output.setText("Wrong answer!!");
            }
        }catch(NullPointerException e){
            System.out.println("You gave an answer without any question");
        }
    }
}
