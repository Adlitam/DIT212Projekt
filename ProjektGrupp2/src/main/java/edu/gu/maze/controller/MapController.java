package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MapView1;
import edu.gu.maze.view.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MapController implements EventHandler<KeyEvent>, PropertyChangeListener{
    IGame model;
    MapView1 view;
    Stage stage;

    public MapController(IGame model, MapView1 view, Stage primaryStage){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }





    Player player = new Player();
    int playerX = player.getxPos();
    int playerY = player.getyPos();

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case UP:
                player.update(playerX,playerY-1);
                //map.getG().add(player, playerX, playerY - 1);

                System.out.println("UP");
                break;

        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
