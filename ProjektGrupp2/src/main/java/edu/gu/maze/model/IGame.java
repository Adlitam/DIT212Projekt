package edu.gu.maze.model;

/**
 *
 * @author omega
 */
public interface IGame {
    //For questions
    //Returns a question
    public String getQuestion();
    //Returns an array of answers of length at least 2.
    public String[] getAnswers();
    //This method takes an int which is an index to the array returned by getAnswers()
    //It returns an array of ints which signify, in order:
    //0 for wrong answer, 1 for correct
    //change in the number of apples
    //change in the number of keys
    //change in the number of final keys
    //change in the number of points
    public int[] isThisTheRightAnswer(int index);
}
