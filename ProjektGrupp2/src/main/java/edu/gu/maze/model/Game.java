package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.*;
import edu.gu.maze.util.ResourceReader;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SuppressFBWarnings("CD_CIRCULAR_DEPENDENCY")
public class Game implements IGame, Serializable{
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    //DATA
    private static final long serialVersionUID = 1L;
    private transient Question[] allQuestions = ResourceReader.readQuestions();
    private final SaveSlot[] slots = new SaveSlot[3];
    private final String[] levels = new String[3];
    private final List<HighScore> totalHighScores = new ArrayList<HighScore>();

    // Sets to True if the game is done so the Controllers know when to end all Animation timers
    private boolean gamesDone;
    private boolean stopLoops;
    
//MATERIAL RELATING TO CURRENT SESSION
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient Question currentQuestion;
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient SaveSlot currentPlayer;
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient Match currentMatch;
    @SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient int currentLevel;
    
    //This is for deserialisation
    private Object readResolve() {
        allQuestions = ResourceReader.readQuestions();
        return this;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public Game(){

        levels[0] = "src/main/resources/edu/gu/maze/util/Level1.txt";
        levels[1] = "src/main/resources/edu/gu/maze/util/Level2.txt";
        levels[2] = "src/main/resources/edu/gu/maze/util/Level3.txt";
        //levels[0] = getClass().getResource("Level1.txt").toString();
        //levels[1] = getClass().getResource("Level2.txt").toString();
        //levels[2] = getClass().getResource("Level3.txt").toString();
    }

    @Override
    public String getQuestion() {
        currentQuestion = selectQuestion();
        return currentQuestion.getQ();
    }

    @Override
    public String[] getAnswers() {
        return currentQuestion.getAnswers();
    }

@Override
public int isThisTheRightAnswer(int index) {
    final boolean a = currentQuestion.isThisTheRightAnswer(index);
    currentQuestion = null;
    if(a){
        currentMatch.correctAnswer();
        return 1;
    }
        currentMatch.wrongAnswer();
        return 0;
}

    @Override
    public Integer getPoints() {
        return currentMatch.getScore();
    }

    @Override
    public void setTime(int min, int sec) {
        currentMatch.setTime(min, sec);
    }

    @Override
    public boolean isTheGameDone() {
        return gamesDone;
    }

    @Override
    public void setStopLoops(boolean bool) {
        stopLoops=bool;
    }

    @Override
    public boolean isStopLoops() {
        return stopLoops;
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

    // Used in GameTest.java
    protected void setKeysApplesScoreFinalKey(){currentMatch.correctAnswer();}

    private Question selectQuestion(){
        final Random gen = new Random();
        final int index = gen.nextInt(allQuestions.length);
        return allQuestions[index];
    }



    @Override
    public void createPlayer(int slot, String name, int type) {
        if (type != MAGE && type != WARRIOR && type != THIEF) {
            throw new IllegalArgumentException("Tried to create player with nonexistent type " + type);
        }

        if (slots[slot] != null) {
            throw new RuntimeException("Slot " + slot + "already contains a player");
        }

        slots[slot] = new SaveSlot(name, type);

        currentPlayer = slots[slot];

    }

    @Override
    public void selectPlayer(int slot){
        if(slots[slot]==null) {
            throw new RuntimeException ("No player found in slot " + slot);
        }
        else {
            currentPlayer = slots[slot];       
        }
    }

    @Override

    public void deletePlayer(int slot){
            if (slots[slot]==null) {
                throw new RuntimeException("slot " + slot + "is already empty.");
            }
            slots[slot]=null;
    }

    @Override
    public void moveUp(){
        final int i = currentMatch.moveUp();
        move(i, "UP");
    }
    
    @Override
    public void moveDown(){
        final int i = currentMatch.moveDown();
        move(i, "DOWN");
    }
    
    @Override
    public void moveLeft(){
        final int i = currentMatch.moveLeft();
        move(i, "LEFT");
    }
    
    @Override
    public void moveRight(){
        final int i = currentMatch.moveRight();
        move(i, "RIGHT");
    }

    private void move(int i , String direction){
        final String v = "value1";
        final String w = "value2";
        if (i == YES){
            pcs.firePropertyChange(direction, v, w);
            pcs.firePropertyChange("YES", v, w);
        }

        // Tells the view that the model dont have any apples
        if(i == APPLE){
            pcs.firePropertyChange("NO_APPLE", v, w);
        }

        // Tells the view that the model have apples
        if(i == GOTAPPLE){
            pcs.firePropertyChange("APPLE", v, w);
        }

        // Tells the view that the model dont have any keys
        if(i == KEY){
            pcs.firePropertyChange("NO_KEY", v, w);
        }

        // Tells the view that the model have keys
        if(i == GOTKEY){
            pcs.firePropertyChange("KEY", v, w);
        }

        // Tells the view that the model dont have the Final key
        if(i == NOFINAL){
            pcs.firePropertyChange("NO_FINAL_KEY", v, w);
        }

        // Tells the view to print out a question and all the possibly answers
        if(i == QUESTIONER){
            pcs.firePropertyChange("QUESTION", getQuestion(), getAnswers());
        }

        // Tells the view that the player opened a chest
        if(i == CHEST){
            pcs.firePropertyChange("CHEST", v, w);
        }

        if (i == FINAL){
            currentMatch.endMatch();
            final int a = currentMatch.getScore();
            final HighScore score = currentPlayer.addHighScore(a, currentLevel);
            addHighScore(score);
            stopLoops = true;
            gamesDone=true;
        }
    }

    @Override
    public String[] getTotalHighScores() {
        final int a = totalHighScores.size();
        String[] ans = new String[a];
        for (int i=0; i<a; i++){
            ans[i]=totalHighScores.get(i).toString();
        }
        return ans;
    }

    //Gets type of currentPlayer
    @Override
    public int getPlayerType(){
        return currentPlayer.getType();
    }
    //Gets type of player in slot
    @Override
    public int getPlayerType(int slot) {
            if (slots[slot]==null) {
                return -1;
            }
            return slots[slot].getType();
    }

    @Override
    public String getPlayerName(int slot) {
        if (slots[slot]==null) {
            return "";
        }
            return slots[slot].name;
    }
    
    @Override
    public int getPlayerTotalScore (int slot){
        if (slots[slot]==null) {
            return -1;
        }
            return slots[slot].getTotalHighScore();
    }
    
    private void addHighScore(HighScore score){
        totalHighScores.add(score);
        Collections.sort(totalHighScores);
        if (totalHighScores.size()>5){
            totalHighScores.remove(totalHighScores.size()-1);
        }
    }

    @Override
    public void setCurrentLevel(int map){
        currentLevel = map;
    }

    @Override
    public String getCurrentMapFilePath(){
        return levels[currentLevel];
    }

    @Override
    public void setCurrentMatch(Match m){
        currentMatch = m;
    }
}