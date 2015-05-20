package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InputOutputView;
import edu.gu.maze.view.MapView1;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MapController implements PropertyChangeListener{
    IGame model;
    MapView1 view;
    InputOutputView inputView;
    Stage stage;
    private TextArea output;
    private String question;
    private String[] answers;

    public MapController(IGame model, MapView1 view, InputOutputView inputView, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.inputView = inputView;
        this.inputView.addPropertyChangeListener(this);
        this.view.addPropertyChangeListener(this);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "Input":
                TextField answer = (TextField) evt.getOldValue();
                output = (TextArea) evt.getNewValue();
                System.out.println(answer.getText());
                output.setText(answer.getText());
                answer.clear();
                break;
            case "UP":
                model.moveUp();
                getQuestionAndAnswers(evt);
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "DOWN":
                model.moveDown();
                getQuestionAndAnswers(evt);
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "LEFT"
                model.moveLeft();
                getQuestionAndAnswers(evt);
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
            case "RIGHT":
                model.moveRight();
                getQuestionAndAnswers(evt);
                output.setText(question + "\n" + answers[0] + "  " + answers[1] + "  " + answers[2]);
                break;
        }
    }

    private void getQuestionAndAnswers(PropertyChangeEvent evt){
        output = (TextArea) evt.getOldValue();
        question = model.getQuestion();
        answers = model.getAnswers();
    }
}
