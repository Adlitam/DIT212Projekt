package edu.gu.maze.model;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Map extends Observable{
    public static GridPane createMap1(){
        GridPane g = new GridPane();
        //g.setHgap(10);   //gep between every row in the gridPane
        //g.setVgap(50);   //gep between every column in the gridPane

        int[] roadRows = {0,
                1,1,1,1,1,1,1,1,1,1,1,1,1,1,   //14
                2,2,2,2,  //4
                3,3,3,3,3,  //5
                4,4,4,4,4,4,4,4,4,4,4,4,4,4,4,  //15
                5,5,5,5,   //4
                6,6,6,6,6,6,6,6,   //8
                7,7,7,7,7,7,7,7,7,7,  //10
                8,8,8,8,8,  //5
                9,9,9,9,9,9,9,9,9,9,9,9,9,9,  //14
                10,10,10,10,10,10,10,  //7
                11,11,11,11,11,11,11,11,11,11,11,  //11
                12,12,12,12,12,12,12,12,12,12,12,12,12,  //13
                13,13,13,13,13,13,13,  //7
                14,14,14,14,14,14,14,14,14,14,14,14,14,  //13
                15};   //#roads on that row
        int[] roadColumns = {13,
                2,3,4,5,6,7,8,9,10,11,12,13,14,15,   //14
                2,15,19,20,   //4
                2,5,7,15,20,   //5
                2,3,4,5,7,9,10,11,12,13,14,15,16,17,20,   //15
                2,7,15,20,   //4
                2,4,5,6,7,11,15,20,   //8
                1,2,7,11,15,16,17,18,19,20,   //10
                1,7,11,20,21,   //5
                1,3,7,8,9,10,11,12,13,14,15,16,18,21,   //14
                1,3,9,11,15,18,21,   //7
                1,3,4,5,6,9,11,15,18,20,21,   //11
                1,3,6,9,11,12,13,14,15,16,17,18,20,   //13
                1,3,6,9,11,16,20,   //7
                1,2,3,6,7,8,9,11,16,17,18,19,20,   //13
                11};    //road in the specific column and the row from above

        for(int i = 0; i <= 15; i++){
            for(int j = 0; j <= 22; j++){
                Wall wall = new Wall(j, i, Color.valueOf("black"));
                g.add(wall, j, i);
            }
        }
        for(int i = 0; i < roadRows.length; i++){
            Road road = new Road(roadColumns[i], roadRows[i], Color.valueOf("gray"));
            g.add(road, roadColumns[i], roadRows[i]);    //node, column, row
        }
        Player player = new Player(11, 15);
        g.add(player, 11, 15);


        return g;
    }


}
