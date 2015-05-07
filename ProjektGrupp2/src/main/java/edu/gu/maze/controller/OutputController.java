package edu.gu.maze.controller;

import javafx.scene.control.TextArea;


/**
 * Created by Johan on 2015-05-07.
 */
public class OutputController {

    private String output ="";
    public TextArea Output(TextArea outputArea) {
        outputArea.setText(output);
        return outputArea;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}