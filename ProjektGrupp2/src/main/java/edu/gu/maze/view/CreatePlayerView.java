package edu.gu.maze.view;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CreatePlayerView {
    private final BorderPane borderPaneLayout;
    private TextField name;
    private ImageView mage;
    private ImageView thief;
    private ImageView warrior;
    private final int slot;
    private Button playButton;
    private Button backButton;

    // Put together all parts of the stage
    public CreatePlayerView(Stage stage, int slot){
        this.slot = slot;
        stage.setTitle("Maze");
        borderPaneLayout = new BorderPane();
        borderPaneLayout.setStyle("-fx-background-image: url(\"highscore.jpg\");");
        createTop();
        createMiddle();
        createBottom();
        final Scene highScoreScene = new Scene(borderPaneLayout, 800, 620);
        stage.setScene(highScoreScene);
    }

    // Creates the top of the stage that includes a label and a TextField
    private void createTop(){
        final GridPane setName = new GridPane();
        final Label title = new Label("Write Your Name:");
        GridPane.setConstraints(title,0,0);
        name = new TextField();
        name.setMinWidth(400);
        GridPane.setConstraints(name,0,1);
        setName.getChildren().addAll(title, name);
        setName.setAlignment(Pos.CENTER);
        borderPaneLayout.setTop(setName);
    }

    // Creates the center of the stage that includes all the Character pictures
    private void createMiddle(){
        final HBox chooseCharacter = new HBox();
        chooseCharacter.getChildren().addAll(getMageNode(),getWarriorNode(),getThiefNode());
        chooseCharacter.setAlignment(Pos.CENTER);
        chooseCharacter.setSpacing(20);
        borderPaneLayout.setCenter(chooseCharacter);
    }

    // Creates the Mage picture and sends away a event if you click on it
    private ImageView getMageNode(){
        final Image image = new Image("Mage.png");
        mage = new ImageView();
        mage.setImage(image);
        mage.setFitHeight(200);
        mage.setFitWidth(200);
        return mage;
    }

    // Creates the Warrior picture and sends away a event if you click on it
    private ImageView getWarriorNode(){
        final Image image = new Image("warrior.png");
        warrior = new ImageView();
        warrior.setImage(image);
        warrior.setFitHeight(250);
        warrior.setFitWidth(200);
        return warrior;
    }

    // Creates the Thief picture and sends away a event if you click on it
    private ImageView getThiefNode(){
        final Image image = new Image("thief.png");
        thief = new ImageView();
        thief.setImage(image);
        thief.setFitHeight(200);
        thief.setFitWidth(200);
        return thief;
    }

    // Creates the bottom of the stage that includes the play and back buttoms
    private void createBottom(){
        final HBox playAndReturn = new HBox();
        playButton = new Button("Play");
        playButton.setPrefWidth(200);
        backButton = new Button("Back to start");
        backButton.setPrefWidth(200);
        playAndReturn.getChildren().addAll(playButton, backButton);
        playAndReturn.setAlignment(Pos.TOP_CENTER);
        playAndReturn.setSpacing(10);
        borderPaneLayout.setBottom(playAndReturn);
    }

    public Button getPlayButton(){
        return playButton;
    }

    public Button getBackButton(){
        return backButton;
    }

    public TextField getName(){
        return name;
    }

    public int getSlot(){
        return slot;
    }

    public ImageView getMage(){
        return mage;
    }

    public ImageView getWarrior(){
        return warrior;
    }

    public ImageView getThief(){
        return thief;
    }
}