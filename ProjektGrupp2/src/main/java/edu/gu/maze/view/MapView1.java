package edu.gu.maze.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Matildaandersson on 15-04-01.
 */
public class MapView1 implements PropertyChangeListener{
    private GridPane g;
    private PlayerView player;
    private ImageView[][] map;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }


    public MapView1() {
        createMapGridPane();
        map = createMapArray("map1.txt");
        initializeGrid();
    }

    private void createMapGridPane(){
        g = new GridPane();
        g.setFocusTraversable(true);
    }

    private ImageView[][] createMapArray(String filename){
        Scanner s = null;
        try{
            s = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println("could not read the file: " + filename);
            System.exit(0);
        }
        ArrayList<ImageView[]> temp1 = new ArrayList();
        int i = 0;
        while(s.hasNext()){
            int j = 0;
            ArrayList<ImageView> temp2 = new ArrayList();
            for(char c : s.next().toCharArray()){
                switch(c){
                    case 'W':
                        temp2.add(new WallView(i,j));
                        break;
                    case 'R':
                        temp2.add(new RoadView(i,j));
                        break;
                    case 'F':
                        temp2.add(new FinalDoorView(i,j));
                        break;
                }
                j++;
            }
            temp1.add(temp2.toArray(new ImageView[temp2.size()]));
            i++;
        }
        map = temp1.toArray(new ImageView[i][temp1.size()]);
        return map;
    }

    private void initializeGrid(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                g.add(map[i][j], j, i);
            }
        }
        player = new PlayerView(11,14);
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
        }
    }
}
