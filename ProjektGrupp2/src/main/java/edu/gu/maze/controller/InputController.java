package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InputView;
import edu.gu.maze.view.MainView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputController implements PropertyChangeListener {
    IGame model;
    InputView view;
    Stage stage;
    String inValue;

    public InputController(IGame model, InputView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }



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


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName() == "backButtonG"){
            MainView mainView = new MainView(stage);
            MainController h = new MainController(model, mainView, stage);
        }
    }
}
