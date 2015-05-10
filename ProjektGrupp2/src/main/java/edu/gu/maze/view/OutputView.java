package edu.gu.maze.view;

import javafx.scene.control.TextArea;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Johan on 2015-05-07.
 */
public class OutputView {
    TextArea output;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    public OutputView(){
        output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);
    }

    public TextArea getOutputView(){
        return output;
    }



    public TextArea createOutput() {
        TextArea output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);
        //new OutputController().Output(output);   //what is this? View shouldn't know about the controller
        return output;
    }
}