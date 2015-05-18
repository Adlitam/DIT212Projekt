package edu.gu.maze.controller;

import edu.gu.maze.model.IGame;
import edu.gu.maze.view.MapView1;
import edu.gu.maze.view.Player;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by xiang-yu on 2015-04-28.
 */
public class MapController implements PropertyChangeListener{
    IGame model;
    MapView1 view;
    Stage stage;
    Player player;

    public MapController(IGame model, MapView1 view, Stage primaryStage, Player player){
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.player = player;
        this.view.addPropertyChangeListener(this);



    }





    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        int playerX = player.getxPos();
        int playerY = player.getyPos();

        if(evt.getPropertyName().equals("Player")){
            player = (Player) evt.getOldValue();
            System.out.print("Moved");

            view.getMap().getChildren().remove(player);
            player.update(11, 14);

            view.getMap().add(player,11,14);


        }



    }




}
