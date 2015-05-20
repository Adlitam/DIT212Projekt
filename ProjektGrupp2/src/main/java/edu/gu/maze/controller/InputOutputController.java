package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InputOutputView;
import edu.gu.maze.view.MainView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Johan on 2015-05-07.
 */
public class InputOutputController implements PropertyChangeListener {
    IGame model;
    InputOutputView view;
    Stage stage;
    TextArea output;
    String question;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }



    public InputOutputController(IGame model, InputOutputView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()) {
            case "backButtonG":
                MainView mainView = new MainView(stage);
                MainController mainController = new MainController(model, stage);
                mainView.addPropertyChangeListener(mainController);
                break;
            case "Input":
                TextField input = (TextField) evt.getOldValue();
                output = (TextArea) evt.getNewValue();
                pcs.firePropertyChange("Input", input, output);
                break;
            case "UP":
                output = (TextArea) evt.getOldValue();
                pcs.firePropertyChange("UP", output, "value2");
                break;
            case "DOWN":
                output = (TextArea) evt.getOldValue();
                pcs.firePropertyChange("DOWN", output, "value2");
                break;
            case "LEFT":
                output = (TextArea) evt.getOldValue();
                pcs.firePropertyChange("LEFT", output, "value2");
                break;
            case "RIGHT":
                output = (TextArea) evt.getOldValue();
                pcs.firePropertyChange("RIGHT", output, "value2");
                break;
        }
    }
}
