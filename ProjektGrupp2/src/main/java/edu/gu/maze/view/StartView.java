package edu.gu.maze.view;

import edu.gu.maze.controller.StartController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartView {
    private Button slot1Button;
    private Button slot2Button;
    private Button slot3Button;
    private Button backButton;
    private BorderPane layout;
    private HBox hBox1 = new HBox();
    private HBox hBox2 = new HBox();
    private HBox hBox3 = new HBox();

    public StartView(Stage stage){
        stage.setTitle("Maze");
        layout = new BorderPane();
        createBottom();
        createPane();
        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");
        Scene startScene = new Scene(layout,800,600);
        stage.setScene(startScene);
    }

    private void createPane(){
        Label playerName1 = new Label("PlayerName1");
        Label playerName2 = new Label("PlayerName2");
        Label playerName3 = new Label("PlayerName3");

        //First slot
        slot1Button = new Button();
        slot1Button.setMinSize(100,100);
        hBox1.getChildren().addAll(slot1Button,playerName1);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);

        //Second slot
        slot2Button = new Button();
        slot2Button.setMinSize(100,100);
        hBox2.getChildren().addAll(slot2Button,playerName2);
        hBox2.setSpacing(10);
        hBox2.setAlignment(Pos.CENTER);

        //Slot 3
        slot3Button = new Button();
        slot3Button.setMinSize(100,100);
        hBox3.getChildren().addAll(slot3Button,playerName3);
        hBox3.setSpacing(10);
        hBox3.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1,hBox2,hBox3);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        layout.setCenter(vBox);
    }

    private void createBottom(){
        HBox hBoxBotton = new HBox();
        backButton = new Button("Back to start");
        backButton.setPrefWidth(200);
        hBoxBotton.getChildren().addAll(backButton);
        hBoxBotton.setAlignment(Pos.BOTTOM_RIGHT);
        hBoxBotton.setSpacing(10);
        layout.setBottom(hBoxBotton);
    }

    public void addController(StartController c){
        slot1Button.setOnAction(c);
        slot2Button.setOnAction(c);
        slot3Button.setOnAction(c);
        backButton.setOnAction(c);
    }

    public Button getSlot1Button(){
        return slot1Button;
    }

    public Button getSlot2Button(){
        return slot2Button;
    }

    public Button getSlot3Button(){
        return slot3Button;
    }

    public Button getBackButton(){
        return backButton;
    }
}