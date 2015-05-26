package edu.gu.maze.model;

import static edu.gu.maze.util.Constants.*;
import edu.gu.maze.util.ResourceReader;
import edu.gu.maze.util.SavedInformationHandler;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements IGame, Serializable{
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    //DATA
    private static final long serialVersionUID = 1L;
    //TODO : Replace this with appropriate data structure of questions.
    private final Question[] allQuestions = ResourceReader.readQuestions();
    private final SaveSlot[] slots = new SaveSlot[3];
    private final Level[] levels = new Level[3];
    ArrayList<HighScore> totalHighScores = new ArrayList();
    private int totalScore = 0;

    private int time;
    private boolean gamesDone = false;
    
//MATERIAL RELATING TO CURRENT SESSION
    //The next line is there just as a template for suppressing bugs.
    //It will get removed before sending in the last time.
    //@SuppressFBWarnings("SE_TRANSIENT_FIELD_NOT_RESTORED")
    private transient Question currentQuestion;
    private transient SaveSlot currentPlayer;
    private transient Match currentMatch;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public Game(){
        levels[0] = new Level ("src/main/resources/edu/gu/maze/util/Level1.txt");
        levels[1] = new Level ("src/main/resources/edu/gu/maze/util/Level1.txt");
        levels[2] = new Level ("src/main/resources/edu/gu/maze/util/Level1.txt");
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
        return 0;
}

//TODO: Decide if you'd rather use these or the same methods in Match
// The Match object can be retrieved using getCurrentMatch() below
    @Override
    public Integer getPoints() {
        return currentMatch.getScore();
    }

    @Override
    public void setTime(int min, int sec) {
        this.time=min*60+sec;
    }

    @Override
    public boolean gamesDone() {
        return gamesDone;
    }


    @Override
    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public void setCurrentMatchToNull() {
        gamesDone = false;
        currentMatch = null;
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
        SavedInformationHandler.saveGame(this);
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
        currentMatch = ResourceReader.readMapForModel(levels[map].getMap());
        pcs.firePropertyChange("MAP_CHOSEN", levels[map].getMap(), "value2");
    }
    
    @Override
    public void deletePlayer(int Slot){
            if (slots[Slot]==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slots[Slot]=null;  
            SavedInformationHandler.saveGame(this);
    }

    //This one isn't currently being used.
    @Override 
    public Match getCurrentMatch() {
        return currentMatch;
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
        if (i != NO){
            pcs.firePropertyChange(direction, "value1", "value2");
        }
        if (i == FINAL){
            totalScore = getPoints() + (500 - time);
            //calculate final score. Communicate to view somehow.
            gamesDone=true;
        }
    }
    
    /*private void sendMessages(int what){
        if (what==APPLE){
            //TODO send message apples-1 and monster not hungry
        }
        else if (what==KEY){
            //send message key-1 and door open
        }
        else if (what==FINAL){
            reset();
            //send message game finished
        }
    }*/

    @Override
    public String[] getHighScoresForMap(int map) {
        return levels[map].getHighScores();
    }

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
}
