package edu.gu.maze.controller;

import edu.gu.maze.util.Constants;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class CreatePlayerController implements PropertyChangeListener {
    private IGame model;
    private Game map;
    private Stage stage;
    private int type;

    public CreatePlayerController(IGame model, Stage primaryStage){
        this.map = (Game) model;
        this.stage = primaryStage;
        this.model = model;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "backButtonH":
                // Take you back to the start stage
                MainView mainView = new MainView(stage);
                MainController mainController = new MainController(model, stage);
                mainView.addPropertyChangeListener(mainController);
                break;

            case "playButton":
                // Start the game only if you have written a name
                TextField input = (TextField) evt.getOldValue();
                String name = input.getText();
                if(name.length() > 0) {
                    play();
                    int slot = (int) evt.getNewValue();

                    System.out.println("Name: " + name);
                    System.out.println("Type: " + type);
                    System.out.println("Slot: " + slot);

                    model.createPlayer(slot, name, type);
                    model.selectMap(Constants.MAP1);
                }else{
                    input.setPromptText("Fill in your name!!!");
                }
                break;

            case "mage":
                // Sets the type to Mage
                removeNotSelected(evt);
                this.type = Constants.MAGE;
                break;

            case "warrior":
                // Sets the type to Warrior
                removeNotSelected(evt);
                this.type = Constants.WARRIOR;
                break;

            case "thief":
                // Sets the type to Thief
                removeNotSelected(evt);
                this.type = Constants.THIEF;
                break;

            default:
        }
    }
    // Remove and disable the two character whos not selected from the view
    private void removeNotSelected(PropertyChangeEvent evt){
        ImageView temp1 = (ImageView) evt.getOldValue();
        ImageView temp2 = (ImageView) evt.getNewValue();
        temp1.setDisable(true);
        temp2.setDisable(true);
        temp1.setVisible(false);
        temp2.setVisible(false);
    }

    // Starts the GameView
    private void play(){
        InfoView infoView = new InfoView();
        InfoController infoController = new InfoController(model, stage);
        infoView.addPropertyChangeListener(infoController);
        InputOutputView inputView = new InputOutputView();
        MapView1 mapView1 = new MapView1();
        map.addPropertyChangeListener(mapView1);
        MapController mapController = new MapController(model, stage);
        mapView1.addPropertyChangeListener(mapController);
        inputView.addPropertyChangeListener(mapController);
        new GameView(stage, mapView1, infoView, inputView);
    }
}
