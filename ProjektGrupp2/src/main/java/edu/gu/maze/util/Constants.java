package edu.gu.maze.util;

/**
 *
 * @author omega
 */
public final class Constants {
    //These variables denote acceptable input for the variables to the methods
    //mentioned below. No other input will be accepted for that variable.
    
    //Slot variable in createPlayer() and selectPlayer() in IGame. 
    public static final int SLOT1 = 1;
    public static final int SLOT2 = 2;
    public static final int SLOT3 = 3;
    
    //Type variable in createPlayer()
    public static final int WARRIOR = 0;
    public static final int MAGE = 1;
    public static final int THIEF = 2;
    
    //These, as well as the variables above, denote map squares
    public static final int ROAD = 3;
    public static final int WALL = 4;
    public static final int CHEST = 5;
    public static final int DOOR = 6;
    public static final int MONSTER = 7;
    public static final int TELEPORTER = 8;
    
    
    //Map variable to retrieve high scores, and to select maps.
    public static final int MAP1=0;
    public static final int MAP2=1;
    public static final int MAP3=2;
    
    //variables which say if you can move to a certain place
    public static final int YES=0;
    public static final int NO=1;
    public static final int APPLE =2;
    public static final int KEY = 3;
    public static final int FINALKEY = 4;
    
}
