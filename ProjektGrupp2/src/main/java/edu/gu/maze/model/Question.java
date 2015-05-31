package edu.gu.maze.model;
import java.util.Arrays;
/**
 *
 * @author omega
 */
public class Question{
    private final String q;
    private final String [] answers;
    private final int rightAnswer;
    public Question(String q, String[] a, int r){
        if (q==null || a==null){
            throw new IllegalArgumentException("Tried to initialize Question object with null");
        }
        this.q = q;
        if (a.length!=3) {
            throw new IllegalArgumentException ("Attempted to initialize a Question with "
                + a.length + " answers. You need 3.");
        }
        answers = Arrays.copyOf(a, a.length);
        if (r<0|| r>= a.length) {
            throw new IllegalArgumentException ("Attempted to initialize a Question with"
                + " bad argument for rightAnswer: " + r);
        }
        rightAnswer = r;
    }
    
    public String getQ(){
        return q;
    }
    
    public String[] getAnswers(){
        return Arrays.copyOf(answers, answers.length);
    }
    
    public boolean isThisTheRightAnswer(int i){
        if (i<0|| i>= answers.length) {
            throw new IllegalArgumentException ("The argument to isThisTheRightAnswer"
                + "must be a valid index of the array returned by getAnswers");
        }
        return i==rightAnswer;
    }
}
