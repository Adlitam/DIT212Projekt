package edu.gu.maze.model;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class Map {
    public static GridPane createMap1(){
        GridPane g = new GridPane();
        //g.setHgap(10);
        //g.setVgap(50);


        Rectangle[] rect = new Rectangle[30];
        rect[0] = new Rectangle(50, 50, Color.BLACK);
        rect[1] = new Rectangle(50, 50, Color.BLACK);
        rect[2] = new Rectangle(50, 50, Color.GRAY);
        rect[3] = new Rectangle(50, 50, Color.BLACK);
        rect[4] = new Rectangle(50, 50, Color.BLACK);
        rect[5] = new Rectangle(50, 50, Color.BLACK);
        rect[6] = new Rectangle(50, 50, Color.BLACK);
        rect[7] = new Rectangle(50, 50, Color.GRAY);
        rect[8] = new Rectangle(50, 50, Color.GRAY);
        rect[9] = new Rectangle(50, 50, Color.BLACK);
        rect[10] = new Rectangle(50, 50, Color.BLACK);
        rect[11] = new Rectangle(50, 50, Color.BLACK);
        rect[12] = new Rectangle(50, 50, Color.BLACK);
        rect[13] = new Rectangle(50, 50, Color.GRAY);
        rect[14] = new Rectangle(50, 50, Color.BLACK);
        rect[15] = new Rectangle(50, 50, Color.GRAY);
        rect[16] = new Rectangle(50, 50, Color.BLACK);
        rect[17] = new Rectangle(50, 50, Color.BLACK);
        rect[18] = new Rectangle(50, 50, Color.GRAY);
        rect[19] = new Rectangle(50, 50, Color.BLACK);
        rect[20] = new Rectangle(50, 50, Color.GRAY);
        rect[21] = new Rectangle(50, 50, Color.GRAY);
        rect[21] = new Rectangle(50, 50, Color.GRAY);
        rect[22] = new Rectangle(50, 50, Color.GRAY);
        rect[23] = new Rectangle(50, 50, Color.GRAY);
        rect[24] = new Rectangle(50, 50, Color.BLACK);
        rect[25] = new Rectangle(50, 50, Color.BLACK);
        rect[26] = new Rectangle(50, 50, Color.BLACK);
        rect[27] = new Rectangle(50, 50, Color.GRAY);
        rect[28] = new Rectangle(50, 50, Color.BLACK);
        rect[29] = new Rectangle(50, 50, Color.BLACK);

        for(int i = 0; i < 5; i++){
            g.add(rect[i], i, 0);
        }
        for(int i = 0, j = 5; i < 5; i++, j++){
            g.add(rect[j], i, 1);
        }
        for(int i = 0, j = 10; i < 5; i++, j++){
            g.add(rect[j], i, 2);
        }
        for(int i = 0, j = 15; i < 5; i++, j++){
            g.add(rect[j], i, 3);
        }
        for(int i = 0, j = 20; i < 5; i++, j++){
            g.add(rect[j], i, 4);
        }
        for(int i = 0, j = 25; i < 5; i++, j++){
            g.add(rect[j], i, 5);
        }

        return g;
    }
}
