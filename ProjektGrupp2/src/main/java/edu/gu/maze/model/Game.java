package edu.gu.maze.model;
import java.io.Serializable;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Game implements IGame, Serializable{
    int currentHighScore = 0;
    private static final long serialVersionUID = 1L;

    @Override
    public String getQuestion() {
        return "This is a dummy question.";
    }

    @Override
    public String[] getAnswers() {
        return new String[] {"Correct answer", "Wrong answer"};
    }

    @Override
    public int[] isThisTheRightAnswer(int index) {
        if (index==0) return new int[] {1,0,0,0,5};
        return new int[] {1,0,0,0,0};
    }
    
}
