package edu.gu.maze.view;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class MapView1 implements PropertyChangeListener{
    private GridPane g;
    PlayerView player;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }


    public MapView1() {
        g = new GridPane();
        player = new PlayerView(11,15, "john");
        g.setFocusTraversable(true);
            g.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent keyEvent) {
                    switch (keyEvent.getCode()) {
                        case UP:
                            pcs.firePropertyChange("UP", "value1", "value2");
                            keyEvent.consume();
                            break;
                        case DOWN:
                            pcs.firePropertyChange("DOWN", "value1", "value2");
                            keyEvent.consume();
                            break;
                        case LEFT:
                            pcs.firePropertyChange("LEFT", "value1", "value2");
                            keyEvent.consume();
                            break;
                        case RIGHT:
                            pcs.firePropertyChange("RIGHT", "value1", "value2");
                            keyEvent.consume();
                            break;
                    }
                }
            });


        int[] roadRows = {0,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,   //14
                2, 2, 2, 2,  //4
                3, 3, 3, 3, 3,  //5
                4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4,  //15
                5, 5, 5, 5,   //4
                6, 6, 6, 6, 6, 6, 6, 6,   //8
                7, 7, 7, 7, 7, 7, 7, 7, 7, 7,  //10
                8, 8, 8, 8, 8,  //5
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,  //14
                10, 10, 10, 10, 10, 10, 10,  //7
                11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,  //11
                12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12,  //13
                13, 13, 13, 13, 13, 13, 13,  //7
                14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14,  //13
                15};   //#roads on that row
        int[] roadColumns = {13,
                2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,   //14
                2, 15, 19, 20,   //4
                2, 5, 7, 15, 20,   //5
                2, 3, 4, 5, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 20,   //15
                2, 7, 15, 20,   //4
                2, 4, 5, 6, 7, 11, 15, 20,   //8
                1, 2, 7, 11, 15, 16, 17, 18, 19, 20,   //10
                1, 7, 11, 20, 21,   //5
                1, 3, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 21,   //14
                1, 3, 9, 11, 15, 18, 21,   //7
                1, 3, 4, 5, 6, 9, 11, 15, 18, 20, 21,   //11
                1, 3, 6, 9, 11, 12, 13, 14, 15, 16, 17, 18, 20,   //13
                1, 3, 6, 9, 11, 16, 20,   //7
                1, 2, 3, 6, 7, 8, 9, 11, 16, 17, 18, 19, 20,   //13
                11};    //road in the specific column and the row from above

        for (int i = 0; i <= 15; i++) {
            for (int j = 0; j <= 22; j++) {
                WallView wallView = new WallView(j, i, Color.valueOf("black"));
                g.add(wallView, j, i);
            }
        }
        for (int i = 0; i < roadRows.length; i++) {
            RoadView roadView = new RoadView(roadColumns[i], roadRows[i]);
            g.add(roadView, roadColumns[i], roadRows[i]);    //node, column, row
        }

        player.update(11, 15);
        g.add(player, 11, 15);
    }
        

    public void movePlayer(int x, int y){
        player.update(x,y);
        g.getChildren().remove(player);
        g.add(player, x, y);
    }

    public GridPane getMap(){
        return g;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "UP":
                //TODO update view
                break;
            case "DOWN":
                //TODO update view
                break;
            case "LEFT":
                //TODO update view
                break;
            case "RIGHT":
                //TODO update view
                break;
        }
    }
}
