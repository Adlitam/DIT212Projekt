package edu.gu.maze.model;

import java.io.IOException;

/**
 *
 * @author omega
 */
public interface IGame {
    //For questions
    //Returns a question
    public String getQuestion();

    /*Returns an array of answers of length at least 2.
    Throws an exception if getQuestion() hasn't been called, or if
    isThisTheRightAnswer() has been called since the last time
    getQuestion() was called.*/
    public String[] getAnswers();

    /*This method takes an int which is an index to the array returned by getAnswers()
    It returns an array of ints which signify, in order:
    0 for wrong answer, 1 for correct
    change in the number of apples
    change in the number of keys
    change in the number of final keys (a correct answer will provide one final key
    if the player doesn't have it yet.
    change in the number of points
    A call to this method must be preceded by a call to getQuestion().
    */
    public int[] isThisTheRightAnswer(int index);
    
    //To create a player and set him/her as current player
    //Slot may be either Constants.SLOT1, Constants.SLOT2, or Constants.SLOT3
    //Type has possible values Constants.MAGE, Constants.WARRIOR, and Constants.THIEF
    //NEW: Throws an exception at any attempt to create a player in a slot that is
    //already occupied.

    public void createPlayer(int Slot, String name, int type);
    //select existing player

    //public abstract void addRoadsToMap();
    public abstract void moveUp();
    public abstract void moveDown();
    public abstract void moveLeft();
    public abstract void moveRight();
    public void selectPlayer (int Slot);
    //Throws an exception if you try to delete a nonexistent player.
    public void deletePlayer (int Slot);
    
    //Retrieve specified high scores as formatted strings.
    //Results are sorted so that highest scores come first and newer scores 
    //before older ones.
    public String[] getHighScoresForMap (int map);
    public String[] getTotalHighScores();
}
