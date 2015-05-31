package edu.gu.maze.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MapView implements PropertyChangeListener{
    private GridPane g;
    private PlayerView player;
    private ImageView[][] map;
    private int mapNr;

    public MapView() {
        createMapGridPane();
    }

    //Initializes the GridPane, g.
    private void createMapGridPane(){
        g = new GridPane();
        g.setFocusTraversable(true);
    }

    //Inserts all the ImageViews the GridPane from the two-dimensional-ImageView-array, map.
    public void initializeGrid(int x, int y){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                g.add(map[i][j], j, i);
            }
        }
        g.add(player, x, y);
    }

    //Move the PlayerView, player, on the GridPane, g.
    private void movePlayer(int x, int y){
        player.update(x,y);
        g.getChildren().remove(player);
        g.add(player, x, y);
    }

    //Returns the GridPane, g.
    public GridPane getMap(){
        return g;
    }

    //Initializes the PlayerView, player, with it's positions and the image
    // associated with the type of character the player has chosen.
    public void initializePlayer(int x, int y, int type){
        player = new PlayerView(x, y, type);
    }

    //Listening on the model for changes
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String s1 = "UP" + mapNr;
        String s2 = "DOWN" + mapNr;
        String s3 = "LEFT" + mapNr;
        String s4 = "RIGHT" + mapNr;
        if(evt.getPropertyName().equals(s1)){
            movePlayer(player.getxPos(), player.getyPos() - 1);
        }
        if(evt.getPropertyName().equals(s2)){
            movePlayer(player.getxPos(),player.getyPos()+1);
        }
        if(evt.getPropertyName().equals(s3)){
            movePlayer(player.getxPos()-1,player.getyPos());
        }
        if(evt.getPropertyName().equals(s4)){
            movePlayer(player.getxPos()+1,player.getyPos());
        }
    }

    //Sets the ImageView[][] map variable.
    public void setMap(ImageView[][] map){
        this.map = map;
    }

    //Sets the int mapNr variable.
    public void setMapNr(int mapNr){
        this.mapNr = mapNr;
    }
}