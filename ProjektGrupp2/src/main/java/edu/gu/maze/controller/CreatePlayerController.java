package edu.gu.maze.controller;

import edu.gu.maze.model.Constants;
import edu.gu.maze.model.Game;
import edu.gu.maze.model.IGame;
import edu.gu.maze.view.*;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class CreatePlayerController implements PropertyChangeListener {
    IGame model;
    Game Map;
    CreatePlayerView view;
    Stage stage;
    Constants cons = new Constants();
    private int type;

    public CreatePlayerController(IGame model, CreatePlayerView view, Stage primaryStage){
        this.Map = (Game) model;
        this.stage = primaryStage;
        this.model = model;
        this.view = view;
        this.view.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "backButtonH":
                MainView mainView = new MainView(stage);
                MainController mainController = new MainController(model, stage);
                mainView.addPropertyChangeListener(mainController);
                break;

            case "playButton":
                TextField input = (TextField) evt.getOldValue();
                String name = input.getText();
                if(name.length() > 0 && !name.equals("Fill in your name!!!")) {
                    play();
                    int slot = (int) evt.getNewValue();

                    System.out.println("Name: " + name);
                    System.out.println("Type: " + type);
                    System.out.println("Slot: " + slot);

                    model.createPlayer(slot, name, type, 11, 14);
                    model.selectMap(Constants.MAP1);
                }else{
                    input.setText("Fill in your name!!!");
                }
                break;

            case "mage":
                ImageView temp1 = (ImageView) evt.getOldValue();
                ImageView temp2 = (ImageView) evt.getNewValue();
                temp1.setDisable(true);
                temp2.setDisable(true);
                temp1.setVisible(false);
                temp2.setVisible(false);

                this.type = cons.MAGE;
                break;

            case "warrior":
                temp1 = (ImageView) evt.getOldValue();
                temp2 = (ImageView) evt.getNewValue();
                temp1.setDisable(true);
                temp2.setDisable(true);
                temp1.setVisible(false);
                temp2.setVisible(false);

                this.type = cons.WARRIOR;
                break;

            case "thief":
                temp1 = (ImageView) evt.getOldValue();
                temp2 = (ImageView) evt.getNewValue();
                temp1.setDisable(true);
                temp2.setDisable(true);
                temp1.setVisible(false);
                temp2.setVisible(false);

                this.type = cons.THIEF;
                break;
        }
    }

    private void play(){
        InfoView infoView = new InfoView();
        new InfoController(model, infoView, stage);
        InputOutputView inputView = new InputOutputView();
        MapView1 mapView1 = new MapView1();
        Map.addPropertyChangeListener(mapView1);
        new MapController(model, mapView1, inputView, stage);
        new GameView(stage, mapView1, infoView, inputView);
    }
}
