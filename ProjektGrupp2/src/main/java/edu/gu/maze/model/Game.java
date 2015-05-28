package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.*;
import edu.gu.maze.util.ResourceReader;
import edu.gu.maze.util.SavedInformationHandler;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@SuppressFBWarnings("CD_CIRCULAR_DEPENDENCY")
public class Game implements IGame, Serializable{
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    //DATA
    private static final long serialVersionUID = 1L;
    private final Question[] allQuestions = ResourceReader.readQuestions();
    private final SaveSlot[] slots = new SaveSlot[3];
    private final String[] levels = new String[3];
    ArrayList<HighScore> totalHighScores = new ArrayList<HighScore>();

    // Sets to True if the game is done so the Controllers know when to end all Animation timers
    private boolean gamesDone = false;
    
//MATERIAL RELATING TO CURRENT SESSION
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient Question currentQuestion;
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient SaveSlot currentPlayer;
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient Match currentMatch;
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient int currentLevel;
    

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public Game(){
        levels[0] = getClass().getResource("Level1.txt").toString();
        levels[1] = getClass().getResource("Level2.txt").toString();
        levels[2] = getClass().getResource("Level3.txt").toString();
    }

    @Override
    public String getQuestion() {
        currentQuestion = selectQuestion();
        return currentQuestion.getQuestion();
    }

    @Override
    public String[] getAnswers() {
        return currentQuestion.getAnswers();
    }

@Override
public int isThisTheRightAnswer(int index) {
    boolean a = currentQuestion.isThisTheRightAnswer(index);
    currentQuestion = null;
    if(a){
        currentMatch.correctAnswer();
        return 1;
    }
        currentMatch.wrongAnswer();
        return 0;
}

// TODO: My precious rows
    @Override
    public Integer getPoints() {
        return currentMatch.getScore();
    }

    @Override
    public void setTime(int min, int sec) {
        currentMatch.setTime(min, sec);
    }

    @Override
    public boolean gamesDone() {
        return gamesDone;
    }

    @Override
    public void setGamesDoneToFalse() {
        gamesDone = false;
    }


    @Override
    public Integer getKeys() {
        return currentMatch.getKeys();
    }

    @Override
    public Integer getApples() {
        return currentMatch.getApples();
    }

    private Question selectQuestion(){
        Random gen = new Random();
        int index = gen.nextInt(allQuestions.length);
        return allQuestions[index];
    }



    @Override
    public void createPlayer(int Slot, String name, int type) {
        if (type != MAGE && type != WARRIOR && type != THIEF) {
            throw new IllegalArgumentException("Tried to create player with nonexistent type " + type);
        }

        if (slots[Slot] != null) {
            throw new RuntimeException("Slot " + Slot + "already contains a player");
        }
        slots[Slot] = new SaveSlot(name, type);

        currentPlayer = slots[Slot];
    }

    @Override
    public void selectPlayer(int Slot){
        if(slots[Slot]!=null) currentPlayer = slots[Slot];
        else {
                throw new RuntimeException ("No player found in slot " + Slot);
        }
    }
    
    @Override
    public void startMatch(int map){
        currentLevel = map;
        currentMatch = ResourceReader.readMapForModel(levels[map]);
        pcs.firePropertyChange("MAP_CHOSEN", levels[map], currentPlayer.getType());
    }
    
    @Override
    public void deletePlayer(int Slot){
            if (slots[Slot]==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slots[Slot]=null;  

    }

//TODO: UPDATE ALL HIGHSCORES ON END OF GAME AND CALL SAVEGAME
    @Override
    public void moveUp(){
        int i = currentMatch.moveUp();
        move(i, "UP");
    }
    
    @Override
    public void moveDown(){
        int i = currentMatch.moveDown();
        move(i, "DOWN");
    }
    
    @Override
    public void moveLeft(){
        int i = currentMatch.moveLeft();
        move(i, "LEFT");
    }
    
    @Override
    public void moveRight(){
        int i = currentMatch.moveRight();
        move(i, "RIGHT");
    }

    private void move(int i , String direction){

        if (i == YES){
            pcs.firePropertyChange(direction, "value1", "value2");
            pcs.firePropertyChange("YES", "value1", "value2");
        }

        // Tells the view that the model dont have any appels
        if(i == APPLE){
            pcs.firePropertyChange("NO_APPLE", "value1", "value2");
        }

        // Tells the view that the model have appels
        if(i == GOTAPPLE){
            pcs.firePropertyChange("APPLE", "value1", "value2");
        }

        // Tells the view that the model dont have any keys
        if(i == KEY){
            pcs.firePropertyChange("NO_KEY", "value1", "value2");
        }

        // Tells the view that the model have keys
        if(i == GOTKEY){
            pcs.firePropertyChange("KEY", "value1", "value2");
        }

        // Tells the view that the model dont have the Final key
        if(i == NOFINAL){
            pcs.firePropertyChange("NO_FINAL_KEY", "value1", "value2");
        }

        // Tells the view to print out a question and all the possibly answers
        if(i == QUESTIONER){
            pcs.firePropertyChange("QUESTION", getQuestion(), getAnswers());
        }

        // Tells the view that the player opened a chest
        if(i == CHEST){
            pcs.firePropertyChange("CHEST", "value1", "value2");
        }

        // TODO or GOTAPPLE and GOTKEY for having received an apple or a key (from a chest).
        if (i == FINAL){
            currentMatch.endMatch();
            int a = currentMatch.getScore();
            HighScore score = currentPlayer.addHighScore(a, currentLevel);
            addHighScore(score);
            gamesDone=true;
            
            pcs.firePropertyChange("GAMESDONE", "value1", "value2");
        }
    }

    /*@Override
    public String[] getHighScoresForMap(int map) {
        return levels[map].getHighScores();
    }*/

    @Override
    public String[] getTotalHighScores() {
        int a = totalHighScores.size();
        String[] ans = new String[a];
        for (int i=0; i<a; i++){
            ans[i]=totalHighScores.get(i).toString();
        }
        return ans;
    }

    @Override
    public int getPlayerType(int Slot) {
            if (slots[Slot]==null) return -1;
            return slots[Slot].type;
    }

    @Override
    public String getPlayerName(int Slot) {
        if (slots[Slot]==null) return "";
            return slots[Slot].name;
    }
    
    @Override
    public int getPlayerTotalScore (int Slot){
        if (slots[Slot]==null) return -1;
            return slots[Slot].getTotalHighScore();
    }
    
    private void addHighScore(HighScore score){
        totalHighScores.add(score);
        Collections.sort(totalHighScores);
        if (totalHighScores.size()>5){
            totalHighScores.remove(totalHighScores.size()-1);
        }
    }
}