package edu.gu.maze.controller;


import edu.gu.maze.view.MapView;
import edu.gu.maze.view.Player;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MapController implements EventHandler<KeyEvent>{

    Player player = new Player();

    MapView map = new MapView();

    int playerX = player.getxPos();
    int playerY = player.getyPos();



    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case UP:
                player.update(playerX,playerY-1);
                map.getG().add(player, playerX, playerY - 1);

                System.out.println("UP");
                break;

        }
    }
}
