package edu.gu.maze.view;

import edu.gu.maze.model.Game;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class MazeMainView {

    private int XPOS = 2;
    private int YPOS = 5;
    private final int XMAX = 5;
    private final int YMAX = 5;
    GridPane layout;
    Rectangle[] rect = new Rectangle[5];
    Circle circle;

    public void mainView(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Maze");
        GridPane layout = new GridPane();

        VBox bottom = new VBox();
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        //If you want to move the circle, click in the commentField
        javafx.scene.control.TextArea output = new javafx.scene.control.TextArea();
        output.setEditable(false);
        output.setWrapText(true);
        javafx.scene.control.TextField input = new javafx.scene.control.TextField();
        input.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    output.setText(input.getText());
                    input.clear();
                    break;
                case UP:
                    moveup();
                    break;
                case DOWN:
                    movedown();
                    break;
            }
        });
        bottom.setPrefSize(screenSize.getWidth(), 100);
        bottom.getChildren().addAll(output, input);

        // BLÄ
        VBox right = new VBox();

        javafx.scene.control.Label apple = new javafx.scene.control.Label("Apple");
        apple.setAlignment(Pos.CENTER);
        apple.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        apple.setStyle("-fx-border-color: black;");

        javafx.scene.control.Label key = new javafx.scene.control.Label("Key");
        key.setAlignment(Pos.CENTER);
        key.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        key.setStyle("-fx-border-color: black;");

        VBox points = new VBox();
        Game gameScore = new Game();
        int currentScore = gameScore.getcurrentHighScore();
        javafx.scene.control.Label text = new javafx.scene.control.Label("Score");
        javafx.scene.control.Label score = new javafx.scene.control.Label();
        score.setText(currentScore + "");
        points.getChildren().addAll(text, score);
        points.setAlignment(Pos.CENTER);
        points.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        points.setStyle("-fx-border-color: black;");

        javafx.scene.control.Label time = new javafx.scene.control.Label("Time");
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        time.setStyle("-fx-border-color: black;");

        right.getChildren().addAll(apple, key, points, time);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(layout);
        borderPane.setBottom(bottom);
        borderPane.setRight(right);

        circle = new Circle(15.0f, javafx.scene.paint.Color.RED);
        //set all rectangels to green
        //add all rectangles to the layout
        for (int i = 0; i < rect.length; i++) {
            rect[i] = new javafx.scene.shape.Rectangle(50, 50, javafx.scene.paint.Color.GREEN);
            layout.add(rect[i], 2, i);
            layout.getRowConstraints().add(new RowConstraints(50));
            layout.getColumnConstraints().add(new ColumnConstraints(50));
        }


        layout.add(circle, 2, 4);
        layout.setValignment(circle, VPos.CENTER);
        layout.setHalignment(circle, HPos.CENTER);
        Scene scene = new Scene(borderPane, 500, 500);
        /*scene.setOnKeyPressed(e -> {
                switch (e.getCode()) {
                    case UP:
                        moveup();
                        break;
                    case DOWN:
                        movedown();
                        break;
                }

        });
       */

        primaryStage.setScene(scene);

        primaryStage.show();
    }


    private void moveup() {
        if (YPOS <= 1) return;
        for (Rectangle r : rect) {
            layout.setRowIndex(r, layout.getRowIndex(r) + 1);
        }
        YPOS--;
    }

    private void movedown() {
        if (YPOS >= YMAX) return;
        for (Rectangle r : rect) {
            layout.setRowIndex(r, layout.getRowIndex(r) - 1);
        }
        YPOS++;
    }
}



