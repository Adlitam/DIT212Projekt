package edu.gu.maze.model;
import java.io.*;
import java.util.HashMap;
import java.util.*;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Game implements IGame, Serializable{
    private static final long serialVersionUID = 1L;
    
    //TODO : Replace this with appropriate data structure of questions.
    private Question allQuestions = new Question("What is Gilderoy Lockhart's favourite colour?",
            new String[]{"Pink", "Lilac", "Gold"}, 1);
    private Player slot1 = new Player("Harry Potter", Constants.MAGE);
    private Player slot2 = null;
    private Player slot3 = null;
    
    
    //TODO: Move this to player class
    private boolean finalkey =false;
    private transient Question currentQuestion = null;
    private transient Player currentPlayer = slot1;

    private HashMap<String, Road> map = new HashMap<>();

    public Game(){
        addRoadsToMap();
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
            throw new IllegalArgumentException("Tried to call createPlayer with type " + type);
        } 
        if (Slot==Constants.SLOT1){
            slot1 = new Player (name, type);
            currentPlayer = slot1;
        }
        else if (Slot == Constants.SLOT2){
            slot2 = new Player (name, type);
            currentPlayer = slot2;
        }
        else if (Slot == Constants.SLOT3){
            slot3 = new Player (name, type);
            currentPlayer = slot3;
        }
        else {
            throw new IllegalArgumentException("Tried to call createPlayer with slot number " + Slot);
        }
    }

    @Override
    public void selectPlayer(int Slot) throws Exception{
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
                throw new Exception ("No player found in slot " + Slot);
            }
            throw new IllegalArgumentException("Tried to call createPlayer with slot number " + Slot);
        }
    }

    public void addRoadsToMap(){
        Scanner s = null;
        try {
            s = new Scanner(new File("C:\\Users\\xiang-yu\\Desktop\\studier\\objektorienterat programmeringsprojekt dit212\\Dit212Projekt\\ProjektGrupp2\\src\\main\\resources\\map1Roads.txt"));
        }catch(IOException e){
            System.out.println("could not open map1Roads.txt");
            System.exit(0);
        }
        while(s.hasNext()){
            Road r = new Road();
            map.put(s.next(),r);
        }
        System.out.println(map.get("7,19"));
    }

    public void moveUp(){
        int x = slot1.getX();
        int y = slot1.getY();
        //TODO
    }
    public void moveDown(){

    }
    public void moveLeft(){

    }
    public void moveRight(){

    }
}
