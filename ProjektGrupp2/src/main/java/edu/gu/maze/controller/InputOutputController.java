package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InputOutputView;
import edu.gu.maze.view.MainView;
import edu.gu.maze.view.Player;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputOutputController implements PropertyChangeListener {
    IGame model;
    InputOutputView view;
    Stage stage;
    String inValue;
    Player player;

    public InputOutputController(IGame model, InputOutputView view, Stage primaryStage, Player player){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.player = player;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("backButtonG")){
            MainView mainView = new MainView(stage);
            new MainController(model, mainView, stage, player);
        }
        if(evt.getPropertyName().equals("Input")){

            TextField input = (TextField) evt.getOldValue();
            inValue = input.getText();
            System.out.println("Button Pressed: Enter");
            System.out.println("Input Value: " + inValue);
            input.clear();
        }
    }


}
