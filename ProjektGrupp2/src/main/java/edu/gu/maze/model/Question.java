package edu.gu.maze.model;
import java.io.Serializable;
/**
 *
 * @author omega
 */
class Question implements Serializable{
    private static final long serialVersionUID = 2L;
    private String question;
    private String [] answers;
    private int rightAnswer;
    public Question(String q, String[] a, int r){
        if (q==null || a==null) 
            throw new NullPointerException("Tried to initialize Question object with null");
        question = q;
        if (a.length<2) 
            throw new IllegalArgumentException ("Attempted to initialize a Question with"
                + "fewer than two answers.");
        answers = a;
        if (r<0|| r>= a.length) 
            throw new IllegalArgumentException ("Attempted to initialize a Question with"
                + "bad argument for rightAnswer: " + r);
        rightAnswer = r;
    }
    public String getQuestion(){
        return question;
    }
    public String[] getAnswers(){
        return answers;
    }
    public boolean isThisTheRightAnswer(int i){
        if (i<0|| i>= answers.length) throw new IllegalArgumentException ("The argument to isThisTheRightAnswer"
                + "must be a valid index of the array returned by getAnswers");
        return i==rightAnswer;
    }
}
