package edu.gu.maze.controller;


import javafx.scene.control.TextField;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputController {

    public TextField getInput(TextField input){
        input.setOnAction(e -> System.out.println(input.getText()));
        return input;
    }


}
