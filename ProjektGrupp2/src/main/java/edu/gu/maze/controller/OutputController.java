package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.OutputView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


/**
 * Created by Johan on 2015-05-07.
 */
public class OutputController implements PropertyChangeListener{
    IGame model;
    OutputView view;
    Stage stage;

    public OutputController(IGame model, OutputView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }



    private String output;
    public TextArea Output(TextArea outputArea) {
        //vet ej hur jag får den att skriva ut ett uppdaterat värde på output
        outputArea.setText(output);
        return outputArea;
    }

    public void setOutput(String output) {
        this.output = output;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}