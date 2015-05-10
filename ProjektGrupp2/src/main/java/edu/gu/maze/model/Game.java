package edu.gu.maze.model;
import java.io.Serializable;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Game implements IGame, Serializable{
    private static final long serialVersionUID = 1L;
    //TODO: Move this to player class
    private boolean finalkey =false;
    //TODO : Replace this with appropriate data structure of questions.
    private Question allQuestions = new Question("What is Gilderoy Lockhart's favourite colour?",
            new String[]{"Pink", "Lilac", "Gold"}, 1);
    private Question currentQuestion = null;
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
    
}
