package edu.gu.maze.view;

import edu.gu.maze.controller.CongratzController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CongratzView {
    private BorderPane layout;
    private Button backButton;
    private Button nextMap;

    public CongratzView(Stage stage){

        stage.setTitle("Maze");

        layout = new BorderPane();

        createBottom();
        createPane();

        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");

        Scene startScene = new Scene(layout,800,600);
        stage.setScene(startScene);

    }

    private void createBottom(){

        nextMap = new Button("Next Map");
        nextMap.setPrefWidth(200);

        backButton = new Button("Back to start");
        backButton.setPrefWidth(200);

        HBox bottom = new HBox();

        bottom.getChildren().addAll(backButton,nextMap);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(20);




    }

    private void createPane(){

        Label title = new Label("Congratulations \n Your score:" );
        title.setFont(new Font(20));
        //Label score = new Label();


    }

    public void addController(CongratzController c){
        backButton.setOnAction(c);
        nextMap.setOnAction(c);
    }

    public Button getBackButton(){
        return backButton;
    }

    public Button getNextMap(){
        return nextMap;
    }
}
