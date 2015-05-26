package edu.gu.maze.view;

import edu.gu.maze.controller.StartController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartView {
    private Button slot1Button = new Button();
    private Button slot2Button = new Button();
    private Button slot3Button = new Button();

    private Button deleteSlot1 = new Button("Delete Player");
    private Button deleteSlot2 = new Button("Delete Player");
    private Button deleteSlot3 = new Button("Delete Player");


    private Button backButton;
    private BorderPane layout;
    private HBox hBox1;

    private ImageView mage,thief,warrior;


    String player1,player2,player3;
    int type1,type2,type3;


    public StartView(Stage stage, String[] playerName, int[] playerType){
        stage.setTitle("Maze");
        layout = new BorderPane();
        getPlayerInfo(playerName,playerType);

        //--------just for the bugs
        for(String x : playerName){

            System.out.print(x + "\n");

        }
        //---------------------------

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
                createSlot(player1, slot1Button,deleteSlot1);
                checkImage(type1,slot1Button);
            }else if(i == 1){
                createSlot(player2, slot2Button,deleteSlot2);
                checkImage(type2,slot2Button);
            }else if(i == 2){
                createSlot(player3, slot3Button,deleteSlot3);
                checkImage(type3, slot3Button);
            }

            vBox.getChildren().addAll(hBox1);
        }



        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        layout.setCenter(vBox);
    }

    private void checkImage(int type,Button slot){

        if(type == 0){
            Image image = new Image("warrior.png");
            warrior = new ImageView();
            warrior.setImage(image);
            warrior.setFitHeight(100);
            warrior.setFitWidth(100);
            slot.setGraphic(warrior);
        }else if(type == 1){
            Image image = new Image("Mage.png");
            mage = new ImageView();
            mage.setImage(image);
            mage.setFitHeight(100);
            mage.setFitWidth(100);
            slot.setGraphic(mage);
        }else if(type == 2){
            Image image = new Image("thief.png");
            thief = new ImageView();
            thief.setImage(image);
            thief.setFitHeight(100);
            thief.setFitWidth(100);
            slot.setGraphic(thief);
        }

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


    private void createSlot(String playerName, Button slotButton,Button delete){

        Label player = new Label(playerName);
        player.setFont(new Font(20));
        slotButton.setMinSize(100, 100);
        hBox1 = new HBox();
        VBox vBox = new VBox();
        vBox.getChildren().addAll(player,delete);
        vBox.setSpacing(50);
        hBox1.getChildren().addAll(slotButton,vBox);
        hBox1.setSpacing(10);
        hBox1.setAlignment(Pos.CENTER);

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

    public boolean checkSlot1(){
        if(player1.equals("")){
            return false;
        }else{
            return true;
        }

    }

    public boolean checkSlot2(){
        if(player2.equals("")){
            return false;
        }else{
            return true;
        }

    }

    public boolean checkSlot3(){
        if(player3.equals("")){
            return false;
        }else{
            return true;
        }

    }

    public void addController(StartController c){
        slot1Button.setOnAction(c);
        slot2Button.setOnAction(c);
        slot3Button.setOnAction(c);
        deleteSlot1.setOnAction(c);
        deleteSlot2.setOnAction(c);
        deleteSlot3.setOnAction(c);
        backButton.setOnAction(c);
    }

    public Button getDeleteSlot1() {
        return deleteSlot1;
    }

    public Button getDeleteSlot2() {
        return deleteSlot2;
    }

    public Button getDeleteSlot3() {
        return deleteSlot3;
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