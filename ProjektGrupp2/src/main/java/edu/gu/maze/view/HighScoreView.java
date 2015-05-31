package edu.gu.maze.view;


import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class HighScoreView{
    private Button backButton,totalScoreButton;
    private final BorderPane borderPaneLayout;
    private final static String FONT = "Verdana";

    private Label player, score;
    private  HBox highScore;
    private String player1,player2,player3;
    private int score1,score2,score3;
    private final HBox hBoxlayout = new HBox();

    public HighScoreView(String[] playerName, int[] playerScore, Stage stage){

        stage.setTitle("Maze");
        borderPaneLayout = new BorderPane();


        getPlayerInfo(playerName,playerScore);
        createList();
        createTop();
        createBotton();


        borderPaneLayout.setStyle("-fx-background-image: url(\"highscore.jpg\");");


        final Scene highScoreScene = new Scene(borderPaneLayout, 800, 620);
        stage.setScene(highScoreScene);
    }

    private final void getPlayerInfo(String[] playerName, int[] playerScore){

        player1 = playerName[0];
        player2 = playerName[1];
        player3 = playerName[2];


        score1 = playerScore[0];
        score2 = playerScore[1];
        score3 = playerScore[2];
    }

    @SuppressFBWarnings("LSC_LITERAL_STRING_COMPARISON")
    private final void createList(){

        final VBox vBoxCenter = new VBox();

        //creates a list for every slot with the total score
        for(int i = 0; i < 3; i++){

            if(i == 0) {
                if("".equals(player1)) {
                    createEmptyLabel();
                }else{
                    createLabel(player1, score1);
                }
            }else if(i == 1){
                if("".equals(player2)) {
                    createEmptyLabel();
                }else{
                    createLabel(player2, score2);
                }
            }else if(i == 2){
                if("".equals(player3)) {
                    createEmptyLabel();
                }else{
                    createLabel(player3, score3);
                }
            }

            vBoxCenter.getChildren().addAll(highScore);

       }


        vBoxCenter.setAlignment(Pos.CENTER);
        vBoxCenter.setSpacing(100);
        vBoxCenter.setStyle("-fx-border-color: Black");

        borderPaneLayout.setCenter(vBoxCenter);


    }

    //Create one panel for the score with the player name and the scores for ever slot
    private final void createLabel(String playerName, Integer scorePlayer){

            player = new Label(playerName);
            player.setFont(new Font(FONT, 40));
            score = new Label(scorePlayer.toString());
            score.setFont(new Font(FONT, 40));
            highScore = new HBox();
            highScore.getChildren().addAll(player, score);
            highScore.setSpacing(100);
            highScore.setAlignment(Pos.CENTER);
            highScore.setStyle("-fx-border-color: Black");


    }

    //Creates a empty panel if the slot is empty
    private final void createEmptyLabel(){

        player = new Label();
        player.setFont(new Font(FONT, 40));
        score = new Label();
        score.setFont(new Font(FONT, 40));
        highScore = new HBox();
        highScore.getChildren().addAll(player, score);
        highScore.setSpacing(100);
        highScore.setAlignment(Pos.CENTER);
        highScore.setStyle("-fx-border-color: Black");

    }

    public final void createTop(){

        final Label title = new Label("TotalScore for every slot.");
        title.setFont(new Font("Cambria", 40));

        final HBox hBoxTop = new HBox();
        hBoxTop.getChildren().addAll(title);
        hBoxTop.setAlignment(Pos.CENTER);

        borderPaneLayout.setTop(hBoxTop);
    }

    public final void createBotton(){
        //Create the botton

        backButton = new Button("Back to start");
        totalScoreButton = new Button("HighScore");
        hBoxlayout.getChildren().addAll(backButton, totalScoreButton);
        hBoxlayout.setAlignment(Pos.CENTER);
        hBoxlayout.setSpacing(50);
        borderPaneLayout.setBottom(hBoxlayout);


    }


    public Button getBackButton(){
        return backButton;
    }

    public Button getTotalScoreButton() {
        return totalScoreButton;
    }
}
