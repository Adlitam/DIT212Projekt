package edu.gu.maze.controller;

import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;


/**
 * Created by Johan on 2015-05-07.
 */
public class OutputController {

    private String output;
    public TextArea Output(TextArea outputArea) {
        //vet ej hur jag får den att skriva ut ett uppdaterat värde på output
        outputArea.setText(output);
        return outputArea;
    }



    public void setOutput(String output) {
        this.output = output;
    }


}