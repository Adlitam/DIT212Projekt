package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MainView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MapController implements PropertyChangeListener{
    IGame model;
    Stage stage;
    private TextArea output;
    private String question;
    private String[] answers;
    private int[] isThisTheRightAnswer;

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
                output = (TextArea) evt.getOldValue();
                getQuestionAndAnswers();
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "DOWN":
                model.moveDown();
                output = (TextArea) evt.getOldValue();
                getQuestionAndAnswers();
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "LEFT":
                model.moveLeft();
                output = (TextArea) evt.getOldValue();
                getQuestionAndAnswers();
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "RIGHT":
                model.moveRight();
                output = (TextArea) evt.getOldValue();
                getQuestionAndAnswers();
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "0":
                output = (TextArea) evt.getOldValue();
                try {
                    isThisTheRightAnswer = model.isThisTheRightAnswer(0);
                    if (isThisTheRightAnswer[0] == 1) {
                        output.setText("Correct answer!!");
                    } else {
                        output.setText("Wrong answer!!");
                    }
                }catch(NullPointerException e){

                }
                break;
            case "1":
                output = (TextArea) evt.getOldValue();
                try {
                    isThisTheRightAnswer = model.isThisTheRightAnswer(1);
                    if (isThisTheRightAnswer[0] == 1) {
                        output.setText("Correct answer!!");
                    } else {
                        output.setText("Wrong answer!!");
                    }
                }catch(NullPointerException e){

                }
                break;
            case "2":
                output = (TextArea) evt.getOldValue();
                try {
                    isThisTheRightAnswer = model.isThisTheRightAnswer(2);
                    if (isThisTheRightAnswer[0] == 1) {
                        output.setText("Correct answer!!");
                    } else {
                        output.setText("Wrong answer!!");
                    }
                }catch(NullPointerException e){

                }
                break;


        }
    }

    private void getQuestionAndAnswers(){
        question = model.getQuestion();
        answers = model.getAnswers();
    }
}
