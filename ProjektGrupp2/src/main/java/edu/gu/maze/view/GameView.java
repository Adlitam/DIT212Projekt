package edu.gu.maze.view;


import edu.gu.maze.model.Game;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;




/**
 * Created by Matildaandersson on 15-04-21.
 */
public class GameView {

   Stage mainStage = new Stage();

    private int XPOS = 2;
    private int YPOS = 5;
    private final int XMAX = 5;
    private final int YMAX = 5;
    GridPane layout;
    Rectangle[] rect = new Rectangle[5];
    Circle circle;


    public Scene gameView(Scene gameScene) {




        GridPane layout = new GridPane();

        VBox bottom = new VBox();
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        //If you want to move the circle, click in the commentField
        TextArea output = new TextArea();
        output.setEditable(false);
        output.setWrapText(true);
        HBox inputAndBack = new HBox();
        TextField input = new TextField();
        input.setPrefWidth(screenSize.getWidth() - 100);
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


        Button backButton = new Button("Back to start");
        backButton.setOnAction(e -> {
            new MazeMainView(mainStage);

        });
        backButton.setMinWidth(100);

        inputAndBack.getChildren().addAll(input,backButton);
        bottom.setPrefSize(screenSize.getWidth(), 100);
        bottom.getChildren().addAll(output, inputAndBack);

        // The planel on the right
        VBox right = new VBox();

        //The label with how many apples the player have
        Label apple = new Label("Apple");
        apple.setAlignment(Pos.CENTER);
        apple.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        apple.setStyle("-fx-border-color: black;");

        //The label with how many keys the player have
        Label key = new Label("Key");
        key.setAlignment(Pos.CENTER);
        key.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        key.setStyle("-fx-border-color: black;");

        VBox points = new VBox();
        Game gameScore = new Game();
        int currentScore = gameScore.getcurrentHighScore();
        Label text = new Label("Score");

        Label score = new Label();
        score.setText(currentScore + "");

        points.getChildren().addAll(text, score);
        points.setAlignment(Pos.CENTER);
        points.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        points.setStyle("-fx-border-color: black;");

        Label time = new Label("Time");
        time.setAlignment(Pos.CENTER);
        time.setPrefSize(100, (screenSize.getHeight() - 100) / 4);
        time.setStyle("-fx-border-color: black;");

        right.getChildren().addAll(apple, key, points, time);


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(layout);
        borderPane.setBottom(bottom);
        borderPane.setRight(right);

        circle = new Circle(15.0f, Color.RED);
        //set all rectangels to green
        //add all rectangles to the layout
        for (int i = 0; i < rect.length; i++) {
            rect[i] = new Rectangle(50, 50, Color.GREEN);
            layout.add(rect[i], 2, i);
            layout.getRowConstraints().add(new RowConstraints(50));
            layout.getColumnConstraints().add(new ColumnConstraints(50));
        }


        layout.add(circle, 2, 4);
        layout.setValignment(circle, VPos.CENTER);
        layout.setHalignment(circle, HPos.CENTER);
        gameScene = new Scene(borderPane, screenSize.getWidth(), screenSize.getHeight());


        return gameScene;


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
