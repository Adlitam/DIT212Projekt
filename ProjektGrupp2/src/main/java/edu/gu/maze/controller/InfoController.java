package edu.gu.maze.controller;


import javafx.scene.control.Label;
//import org.apache.commons.lang.time.StopWatch;


/**
 * Created by Johan on 2015-05-07.
 */
public class InfoController {

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


}
