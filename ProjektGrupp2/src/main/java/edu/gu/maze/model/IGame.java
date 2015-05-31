package edu.gu.maze.model;

/**
 *
 * @author omega
 */
public interface IGame {
    //For questions
    //Returns a question
    String getQuestion();

    /*Returns an array of answers of length 3.
    Throws an exception if getQuestion() hasn't been called, or if
    isThisTheRightAnswer() has been called since the last time
    getQuestion() was called.*/
    String[] getAnswers();

    // return 1 if it is true or 0 if it is false
    // sets apple to apple + 1 if its true
    // sets key to key + 1 if its true
    // sets points to points + 1 if its true
    // change in the number of final keys (a correct answer will provide one final key
    // if the player doesn't have it yet.
    int isThisTheRightAnswer(int index);

    //void startMatch(int map);
    // returns the number of Apples the user has
    Integer getApples();

    // returns the number of Keys the user has
    Integer getKeys();

    // returns the number of Points the user has
    Integer getPoints();

    // Takes the time from controller
    void setTime(int min, int sec);

    // Tells the controllers if the game is done
    boolean isTheGameDone();

    // Tells the controllers to stop all loop
    void setStopLoops(boolean bool);
    boolean isStopLoops();

    void setGamesDoneToFalse();

    //To create a player and set him/her as current player
    //Slot may be either Constants.SLOT1, Constants.SLOT2, or Constants.SLOT3
    //Type has possible values Constants.MAGE, Constants.WARRIOR, and Constants.THIEF
    //NEW: Throws an exception at any attempt to create a player in a slot that is
    //already occupied.

    void createPlayer(int slot, String name, int type);
    //select existing player
    void selectPlayer (int slot);
    
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
    
    //Throws an exception if you try to delete a nonexistent player.
    void deletePlayer (int slot);

    //Retrieve specified high scores as formatted strings.
    //Results are sorted so that highest scores come first and newer scores 
    //before older ones.
    String[] getTotalHighScores();
    
    // returns the type of the player in slot, or -1 if there is no player in the slot.
    int getPlayerType(int slot);
    //Returns the type of the current player.
    int getPlayerType();
    
    //Returns player name or empty string if there is no player in the slot.
    String getPlayerName(int slot);
    
    //Returns a player's combined high score for all maps, or -1 if there is no player in slot.
    int getPlayerTotalScore (int slot);

    String getCurrentMapFilePath();
    void setCurrentMatch(Match m);
    void setCurrentLevel(int map);
}
