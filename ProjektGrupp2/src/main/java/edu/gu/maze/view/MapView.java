package edu.gu.maze.view;

import edu.gu.maze.controller.MapController;
import edu.gu.maze.util.ResourceReader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapView implements PropertyChangeListener{
    private GridPane g;
    private PlayerView player;
    private ImageView[][] map;

    public MapView() {
        createMapGridPane();
    }

    private void createMapGridPane(){
        g = new GridPane();
        g.setFocusTraversable(true);
    }

    private void initializeGrid(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                g.add(map[i][j], j, i);
            }
        }
        g.add(player, 11, 14);
    }

    private void movePlayer(int x, int y){
        player.update(x,y);
        g.getChildren().remove(player);
        g.add(player, x, y);
    }

    public GridPane getMap(){
        return g;
    }

    private void initializePlayer(String filename){
        Scanner s = null;
        try{
            s = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println("could not read the file: " + filename + " while trying to initialize player in view.");
            System.exit(0);
        }
        int x = Integer.parseInt(s.next());
        int y = Integer.parseInt(s.next());
        player = new PlayerView(x,y);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch(evt.getPropertyName()){
            case "UP":
                movePlayer(player.getxPos(),player.getyPos()-1);
                break;
            case "DOWN":
                movePlayer(player.getxPos(),player.getyPos()+1);
                break;
            case "LEFT":
                movePlayer(player.getxPos()-1,player.getyPos());
                break;
            case "RIGHT":
                movePlayer(player.getxPos()+1,player.getyPos());
                break;
            case "MAP_CHOSEN":
                map = ResourceReader.readMapForView((String) evt.getOldValue());
                initializePlayer((String) evt.getOldValue());
                initializeGrid();
                break;
            default:
                System.out.println("reached mapView with unknown event: " + evt.getPropertyName());
                System.exit(0);
        }
    }

    public void addController(MapController c){
        g.setOnKeyPressed(c);
    }
}