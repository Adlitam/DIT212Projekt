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
    private Button slot1Button = new Button();
    private Button slot2Button = new Button();
    private Button slot3Button = new Button();

    private Button backButton;
    private BorderPane layout;
    private HBox hBox;

    String player1,player2,player3;
    int type1,type2,type3;


    public StartView(Stage stage, String[] playerName, int[] playerType){
        stage.setTitle("Maze");
        layout = new BorderPane();
        getPlayerInfo(playerName,playerType);

        for(String x : playerName){

            System.out.print(x);

        }


        createBottom();
        createPane();
        layout.setStyle("-fx-background-image: url(\"highscore.jpg\");");
        Scene startScene = new Scene(layout,800,600);
        stage.setScene(startScene);
    }

    private void createPane(){
        VBox vBox = new VBox();
        for(int i = 0; i<3; i++){
            if(i == 0){
                createSlot(player1, slot1Button);
            }else if(i == 1){
                createSlot(player2, slot2Button);
            }else if(i == 2){
                createSlot(player3, slot3Button);
            }

            vBox.getChildren().addAll(hBox);
        }



        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        layout.setCenter(vBox);
    }

    private void checkImage(){


    }

    private void getPlayerInfo(String[] playerName,int[] playerType){
        //gets the player name
        player1 = playerName[0];
        player2 = playerName[1];
        player3 = playerName[2];

        //gets the player types
        type1 = playerType[0];
        type2 = playerType[1];
        type3 = playerType[2];


    }


    private void createSlot(String playerName, Button slotButton){

        Label player = new Label(playerName);
        slotButton.setMinSize(100,100);
        hBox = new HBox();
        hBox.getChildren().addAll(slotButton,player);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

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