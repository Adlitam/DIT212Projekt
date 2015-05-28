package edu.gu.maze.view;

import edu.gu.maze.controller.MapController;
import edu.gu.maze.util.ResourceReader;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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

    //initializes the GridPane, g.
    private void createMapGridPane(){
        g = new GridPane();
        g.setFocusTraversable(true);
    }

    //inserts all the ImageViews the GridPane from the two-dimensional-ImageView-array, map.
    private void initializeGrid(int x, int y){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                g.add(map[i][j], j, i);
            }
        }
        g.add(player, x, y);
    }

    //move the PlayerView, player, on the GridPane, g.
    private void movePlayer(int x, int y){
        player.update(x,y);
        g.getChildren().remove(player);
        g.add(player, x, y);
    }

    //returns the GridPane, g.
    public GridPane getMap(){
        return g;
    }

    //initializes the PlayerView, player, with it's positions, which it gets from the
    //current level-text file that the model is using.
    @SuppressFBWarnings({"DM_DEFAULT_ENCODING", "NP_NULL_ON_SOME_PATH_EXCEPTION"})
    private void initializePlayer(String filename, int type){
        Scanner s = null;
        try{
            s = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println("could not read the file: " + filename + " while trying to initialize player in view.");
        }
        int x = Integer.parseInt(s.next());
        int y = Integer.parseInt(s.next());
        player = new PlayerView(x, y, type);
    }

    //listening on the model for changes
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
                initializePlayer((String) evt.getOldValue(), (int) evt.getNewValue());
                initializeGrid(player.getxPos(), player.getyPos());
                break;
            default:
        }
    }
}