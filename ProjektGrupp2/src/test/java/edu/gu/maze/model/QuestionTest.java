package edu.gu.maze.model;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author omega
 */
public class QuestionTest {
    public Question question;
    public final String q = "I'm a question.";
    public final String[] answers = {"Answer 1", "Answer2", "Answer3"};
    public final int rightAnswer = 1;
    @Test
    //Also tests the getters
    public void createQuestionWithProperValues(){
        question = new Question(q, answers, rightAnswer);
        assertTrue (question.getQ().equals(q) && Arrays.equals(question.getAnswers(), answers) && question.isThisTheRightAnswer(rightAnswer));
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void createQuestionWithNullForQuestion(){
        question = new Question(null, answers, rightAnswer);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void createQuestionWithNullForAnswer(){
        question = new Question(q, null, rightAnswer);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void createQuestionWithImpossibleAnswer(){
        question = new Question(q, answers, -1);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void createQuestionWithNoAnswers(){
        question = new Question(q, new String[]{}, 1);
    }
}
