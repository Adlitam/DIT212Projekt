package edu.gu.maze.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

public class MapView implements PropertyChangeListener{
    private GridPane g;
    private PlayerView player;
    private ImageView[][] map;
    private boolean inUse;

    public MapView() {
        createMapGridPane();
        inUse = true;
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
        if(inUse){
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
                default:
            }
        }
    }

    //Sets the ImageView[][] map variable.
    public void setMap(ImageView[][] map){
        this.map = Arrays.copyOf(map, map.length);
    }

    //temporary solution that inactivates the mapView.
    public void inactivate(){
        inUse = false;
    }
}