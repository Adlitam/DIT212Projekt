package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.InfoView;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
//import org.apache.commons.lang.time.StopWatch;


/**
 * Created by Johan on 2015-05-07.
 */
public class InfoController implements PropertyChangeListener{
    IGame model;
    InfoView view;
    Stage stage;

    public InfoController(IGame model, InfoView view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }



    private Label label;
    private String time;
    //StopWatch timer = new StopWatch();

    public Label timeController(Label l){
        //timer.start();
        this.label=l;
        //time = timer.toString();
        label.setText(time);
        return label;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
