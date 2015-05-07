package edu.gu.maze.view;

import edu.gu.maze.controller.OutputController;
import javafx.scene.control.TextArea;


/**
 * Created by Johan on 2015-05-07.
 */
public class OutputView {
    public TextArea createOutput() {
        TextArea output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);
        new OutputController().Output(output);
        return output;
    }


}
