package edu.gu.maze.model;


import static edu.gu.maze.util.Constants.*;
//import static edu.gu.maze.util.Constants.APPLE;
import edu.gu.maze.util.ResourceReader;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Game implements IGame, Serializable{
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    //DATA
    private static final long serialVersionUID = 1L;
    //TODO : Replace this with appropriate data structure of questions.
    private Question allQuestions = new Question("What is Gilderoy Lockhart's favourite colour?",
            new String[]{"A. Pink", "S. Lilac", "D. Gold"}, 1);
    private SaveSlot slot1;
    private SaveSlot slot2;
    private SaveSlot slot3;
    private Level level1;
    private Level level2;
    private Level level3;
    ArrayList<HighScore> totalHighScores = new ArrayList();
    //MATERIAL RELATING TO CURRENT GAME
    //TODO: Move this to player class
    //private transient boolean finalkey =false;
    private transient Question currentQuestion;
    private SaveSlot currentPlayer;
    private transient Match currentMatch;


    //private int apple = 0;
    //private int key = 0;
    //private int points = 0;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }


    public Game() throws FileNotFoundException{
        level1 = new Level ("src/main/resources/edu/gu/maze/util/Level1.txt");
        level2 = new Level ("src/main/resources/edu/gu/maze/util/Level1.txt");
        level3 = new Level ("src/main/resources/edu/gu/maze/util/Level1.txt");
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
/*
    @Override
    //TODO: FIX THIS TO USE MESSAGES INSTEAD. ALSO REMOVE LINE IN RESET WHEN YOU DO THIS.
    public int[] isThisTheRightAnswer(int index) {
        boolean a = currentQuestion.isThisTheRightAnswer(index);
        int ans = a ? 1 : 0;
        //int apple = a ? 1 : 0;
        //int key = a ? 1 : 0;
        int fk = 0;
        if (a&&!finalkey){
            finalkey=true;
            fk=1;
        }
        int points = a ? 5 : 0;

        return new int[] {ans,0,0,fk,points};
    }
    */

    // TODO om ni inte gillar den här lösningen så ta bort härifrån till
    // Gamla lösningen är ovanför
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
    @Override
    public Integer getPoints() {
        return currentMatch.getScore();
    }

    @Override
    public Integer getKeys() {
        return currentMatch.getKeys();
    }

    @Override
    public Integer getApples() {
        return currentMatch.getApples();
    }

    // TODO hit

    private Question selectQuestion(){
        return allQuestions;
    }



    @Override
    public void createPlayer(int Slot, String name, int type) {
        if (type !=MAGE && type != WARRIOR && type != THIEF){
            throw new IllegalArgumentException("Tried to create player with nonexistent type " + type);
        } 
        if (Slot==SLOT1){
            if (slot1!=null) throw new RuntimeException("Slot " + Slot + "already contains a player");
            slot1 = new SaveSlot (name, type);
            currentPlayer = slot1;
        }
        else if (Slot == SLOT2){
            if (slot2!=null) throw new RuntimeException("Slot " + Slot + "already contains a player");
            slot2 = new SaveSlot (name, type);
            currentPlayer = slot2;
        }
        else if (Slot == SLOT3){
            if (slot3!=null) throw new RuntimeException("Slot " + Slot + "already contains a player");
            slot3 = new SaveSlot (name, type);
            currentPlayer = slot3;
        }
        else {
            throw new IllegalArgumentException("Tried to create player in nonexistent slot " + Slot);
        }
    }

    @Override
    public void selectPlayer(int Slot){
        if (Slot==SLOT1 && slot1!=null){
            currentPlayer = slot1;
        }
        else if (Slot == SLOT2&&slot2!=null){
            currentPlayer = slot2;
        }
        else if (Slot == SLOT3&&slot3!=null){
            currentPlayer = slot3;
        }
        else {
            if (Slot==SLOT1||Slot==SLOT2||Slot==SLOT3){
                throw new RuntimeException ("No player found in slot " + Slot);
            }
            throw new IllegalArgumentException("Tried to select nonexistent player"
                    + " with slot number " + Slot);
        }
    }
    
    @Override
    public void startMatch(int map){
        if (map==MAP1){
            currentMatch = ResourceReader.readMapForModel(level1.getMap());
        }
        else if (map == MAP2){
            currentMatch = ResourceReader.readMapForModel(level2.getMap());
        }
        else if (map == MAP3){
            currentMatch = ResourceReader.readMapForModel(level3.getMap());
        }
        else {
            throw new IllegalArgumentException("Tried to select nonexistent map"
                    + " with map number " + map);
        }
    }
    
    @Override
    public void deletePlayer(int Slot){
        if (Slot==SLOT1){
            if (slot1==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slot1=null;
        }
        else if (Slot==SLOT2){
            if (slot1==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slot2=null;
        }
        else if (Slot==SLOT3){
            if (slot1==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slot3=null;
        }
        else throw new IllegalArgumentException("Tried to delete player in slot " + Slot);
    }

    @Override //wait what?
    public Match getCurrentMap() {
        return currentMatch;
    }


    public void moveUp(){
        int i = currentMatch.moveUp();
        if (i != NO){
            pcs.firePropertyChange("UP", "value1", "value2");
        }
        if (i == FINAL){
            //calculate final score. Communicate to view somehow.
            currentMatch = null;
        }
    }
    
    @Override
    public void moveDown(){
        int i = currentMatch.moveDown();
        if (i != NO){
            pcs.firePropertyChange("DOWN", "value1", "value2");
        }
        if (i == FINAL){
            //calculate final score. Communicate to view somehow.
            currentMatch = null;
        }
    }
    
    @Override
    public void moveLeft(){
        int i = currentMatch.moveLeft();
        if (i != NO){
            pcs.firePropertyChange("LEFT", "value1", "value2");
        }
        if (i == FINAL){
            //calculate final score. Communicate to view somehow.
            currentMatch = null;
        }
    }
    
    @Override
    public void moveRight(){
        int i = currentMatch.moveRight();
        if (i != NO){
            pcs.firePropertyChange("RIGHT", "value1", "value2");
        }
        if (i == FINAL){
            //calculate final score. Communicate to view somehow.
            currentMatch = null;
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
    
    //this method resets all temporary variables used when playing

    @Override
    public String[] getHighScoresForMap(int map) {
        if (map==MAP1){
            return level1.getHighScores();
        }
        else if (map==MAP2){
            return level2.getHighScores();
        }
        else if (map==MAP3){
            return level3.getHighScores();
        }
        else throw new IllegalArgumentException ("Tried to obtain high scores for "
                + "nonexisting map " + map);
        
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
        if (Slot==SLOT1){
            if (slot1==null) return -1;
            return slot1.type;
        }
        else if (Slot==SLOT2){
            if (slot1==null) return -1;
            return slot2.type;
        }
        else if (Slot==SLOT3){
            if (slot1==null) return -1;
            return slot3.type;
        }
        else throw new IllegalArgumentException("Tried to delete player in slot " + Slot);
    }

    @Override
    public String getPlayerName(int Slot) {
        if (Slot==SLOT1){
            if (slot1==null) return "";
            return slot1.name;
        }
        else if (Slot==SLOT2){
            if (slot1==null) return "";
            return slot2.name;
        }
        else if (Slot==SLOT3){
            if (slot1==null) return "";
            return slot3.name;
        }
        else throw new IllegalArgumentException("Tried to delete player in slot " + Slot);
    }
}
