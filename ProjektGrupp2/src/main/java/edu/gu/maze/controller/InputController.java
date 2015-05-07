package edu.gu.maze.controller;


import javafx.scene.control.TextField;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputController {
    String inValue;

    public String getInValue() {
        return inValue;
    }

    public TextField getInput(TextField input){
        input.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    this.inValue = input.getText();
                    System.out.println(inValue);
                    input.clear();
                    break;
            }
        });


        return input;
    }


}
