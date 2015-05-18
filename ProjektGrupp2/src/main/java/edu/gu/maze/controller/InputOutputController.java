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
    String inValue;
    TextArea output;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
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
                new MainController(model, mainView, stage);
                break;
            case "Input":
                TextField input = (TextField) evt.getOldValue();
                inValue = input.getText();
                System.out.println("Button Pressed: Enter");
                System.out.println("Input Value: " + inValue);
                input.clear();
                break;
            case "UP":
                output = (TextArea) evt.getOldValue();
                output.setText("Up");
                pcs.firePropertyChange("UP", "value1", "value2");
                break;
            case "DOWN":
                output = (TextArea) evt.getOldValue();
                output.setText("Down");
                pcs.firePropertyChange("DOWN", "value1", "value2");
                break;
            case "LEFT":
                output = (TextArea) evt.getOldValue();
                output.setText("Left");
                pcs.firePropertyChange("LEFT", "value1", "value2");
                break;
            case "RIGHT":
                output = (TextArea) evt.getOldValue();
                output.setText("Right");
                pcs.firePropertyChange("RIGHT", "value1", "value2");
                break;
        }
    }
}
