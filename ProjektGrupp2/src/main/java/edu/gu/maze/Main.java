package edu.gu.maze;


import edu.gu.maze.view.MazeMainView;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;

/*
  Application entry class (if using standard java and Swing)
*/
public final class Main extends Application {

    private int XPOS = 2;
    private int YPOS = 5;
    private final int XMAX = 5;
    private final int YMAX = 5;

    public static void main(String[] args) {

       launch(args);
    }
    GridPane layout;
    Rectangle a, b, c, d, e;
    Circle circle;
    ArrayList<Rectangle> boxes;
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Maze");
        layout = new GridPane();
        circle = new Circle(15.0f, Color.RED);
        a = new Rectangle(50,50, Color.GREEN);
        b = new Rectangle(50,50, Color.GREEN);
        c = new Rectangle(50,50, Color.GREEN);
        d = new Rectangle(50,50, Color.GREEN);
        e = new Rectangle(50,50, Color.GREEN);
        layout.add(a,2,0);
        layout.add(b,2,1);
        layout.add(c,2,2);
        layout.add(d,2,3);
        layout.add(e,2,4);
        boxes = new ArrayList();
        boxes.add(a);
        boxes.add(b);
        boxes.add(c);
        boxes.add(d);
        boxes.add(e);
        layout.add(circle,2,4);
        layout.getRowConstraints().add(new RowConstraints(50));
        layout.getRowConstraints().add(new RowConstraints(50));
        layout.getRowConstraints().add(new RowConstraints(50));
        layout.getRowConstraints().add(new RowConstraints(50));
        layout.getRowConstraints().add(new RowConstraints(50));
        layout.getColumnConstraints().add(new ColumnConstraints(50));
        layout.getColumnConstraints().add(new ColumnConstraints(50));
        layout.getColumnConstraints().add(new ColumnConstraints(50));
        layout.getColumnConstraints().add(new ColumnConstraints(50));
        layout.getColumnConstraints().add(new ColumnConstraints(50));
        layout.setValignment(circle,javafx.geometry.VPos.CENTER);
        layout.setHalignment(circle,javafx.geometry.HPos.CENTER);
        Scene scene = new Scene(layout,250,2500, Color.BLACK);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    moveup();break;
                    case RIGHT: circle.setCenterX(circle.getCenterX() + POS); break;
                    case DOWN:  movedown(); break;
                    case LEFT:  circle.setCenterX(circle.getCenterX() - POS); break;
                }
            }
        });




        primaryStage.setScene(scene);

        primaryStage.show();
    }
    private void moveup(){
        if (YPOS<=1) return;
        for (Rectangle r : boxes){
            layout.setRowIndex(r,layout.getRowIndex(r)+1);
        }
        YPOS--;
    }
    private void movedown(){
        if (YPOS>=YMAX) return;
        for (Rectangle r : boxes){
            layout.setRowIndex(r,layout.getRowIndex(r)-1);
        }
        YPOS++;
    }
}
