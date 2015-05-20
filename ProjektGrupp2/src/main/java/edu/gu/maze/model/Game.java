package edu.gu.maze.model;


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
    private Player slot1;
    private Player slot2;
    private Player slot3;
    private Map map1;
    private Map map2;
    private Map map3;
    ArrayList<HighScore> totalHighScores = new ArrayList();
    //MATERIAL RELATING TO CURRENT GAME
    //TODO: Move this to player class
    private transient boolean finalkey =false;
    private transient Question currentQuestion;
    private Player currentPlayer;
    private transient Map currentMap;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }


    public Game() throws FileNotFoundException{
        map1 = new Map("map1.txt", 14, 11);
        map2 = new Map("map2.txt", 0, 0);
        map3 = new Map("map3.txt", 0, 0);
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
        currentQuestion=null;
        return new int[] {ans,0,0,fk,points};
    }
    private Question selectQuestion(){
        return allQuestions;
    }

    @Override
    public void createPlayer(int Slot, String name, int type) {
        if (type !=Constants.MAGE && type != Constants.WARRIOR && type != Constants.THIEF){
            throw new IllegalArgumentException("Tried to create player with nonexistent type " + type);
        } 
        if (Slot==Constants.SLOT1){
            if (slot1!=null) throw new RuntimeException("Slot " + Slot + "already contains a player");
            slot1 = new Player (name, type);
            currentPlayer = slot1;
        }
        else if (Slot == Constants.SLOT2){
            if (slot2!=null) throw new RuntimeException("Slot " + Slot + "already contains a player");
            slot2 = new Player (name, type);
            currentPlayer = slot2;
        }
        else if (Slot == Constants.SLOT3){
            if (slot3!=null) throw new RuntimeException("Slot " + Slot + "already contains a player");
            slot3 = new Player (name, type);
            currentPlayer = slot3;
        }
        else {
            throw new IllegalArgumentException("Tried to create player in nonexistent slot " + Slot);
        }
    }

    @Override
    public void selectPlayer(int Slot){
        if (Slot==Constants.SLOT1 && slot1!=null){
            currentPlayer = slot1;
        }
        else if (Slot == Constants.SLOT2&&slot2!=null){
            currentPlayer = slot2;
        }
        else if (Slot == Constants.SLOT3&&slot3!=null){
            currentPlayer = slot3;
        }
        else {
            if (Slot==Constants.SLOT1||Slot==Constants.SLOT2||Slot==Constants.SLOT3){
                throw new RuntimeException ("No player found in slot " + Slot);
            }
            throw new IllegalArgumentException("Tried to select nonexistent player"
                    + " with slot number " + Slot);
        }
    }
    
    @Override
    public void selectMap(int map){
        if (map==Constants.MAP1){
            currentMap = map1;
        }
        else if (map == Constants.MAP2){
            currentMap = map2;
        }
        else if (map == Constants.MAP3){
            currentMap = map3;
        }
        else {
            throw new IllegalArgumentException("Tried to select nonexistent map"
                    + " with map number " + map);
        }
    }
    
    @Override
    public void deletePlayer(int Slot){
        if (Slot==Constants.SLOT1){
            if (slot1==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slot1=null;
        }
        else if (Slot==Constants.SLOT2){
            if (slot1==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slot2=null;
        }
        else if (Slot==Constants.SLOT3){
            if (slot1==null) throw new RuntimeException("Slot " + Slot + "is already empty.");
            slot3=null;
        }
        else throw new IllegalArgumentException("Tried to delete player in slot " + Slot);
    }

    @Override
    public Map getCurrentMap() {
        return currentMap;
    }


    public void moveUp(){
        int i = currentMap.tryMoveUp();
        int ans = currentPlayer.moveUp(i);
        if(ans == Constants.YES){
            currentMap.moveUp();
            pcs.firePropertyChange("UP", "value1", "value2");
        }
    }
    
    @Override
    public void moveDown(){
        int i = currentMap.tryMoveDown();
        int ans = currentPlayer.moveDown(i);
        if(ans == Constants.YES){
            currentMap.moveDown();
            pcs.firePropertyChange("DOWN", "value1", "value2");
        }
    }
    
    @Override
    public void moveLeft(){
        int i = currentMap.tryMoveLeft();
        int ans = currentPlayer.moveLeft(i);
        if(ans == Constants.YES){
            currentMap.moveLeft();
            pcs.firePropertyChange("LEFT", "value1", "value2");
        }
    }
    
    @Override
    public void moveRight(){
        int i = currentMap.tryMoveRight();
        int ans = currentPlayer.moveRight(i);
        if(ans == Constants.YES){
            currentMap.moveRight();
            pcs.firePropertyChange("RIGHT", "value1", "value2");
        }
    }

    @Override
    public String[] getHighScoresForMap(int map) {
        if (map==Constants.MAP1){
            return map1.getHighScores();
        }
        else if (map==Constants.MAP2){
            return map2.getHighScores();
        }
        else if (map==Constants.MAP3){
            return map3.getHighScores();
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
}
