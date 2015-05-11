package edu.gu.maze.model;

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
    
    //NOTE: METHODS BELOW HAVE NOT BEEN IMPLEMENTED YET.
    //To create a player and set him/her as current player
    //Slot may be either 0, 1, or 2. Type has the same possible values, representing
    //warrior, mage and thief respectively.
    public void createPlayer(int Slot, String name, int type);
    //select existing player
    public void selectPlayer (int Slot);
}
