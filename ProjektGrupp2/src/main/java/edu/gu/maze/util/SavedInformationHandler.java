package edu.gu.maze.util;

import edu.gu.maze.model.Game;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author omega
 */
public final class SavedInformationHandler {

    private SavedInformationHandler(){}
    //Retrieve saved state, if any.
    //If none can be found, return a new Game object.
    public static Game retrieveGame() {
        Game result;
        ObjectInputStream in = null;
        try {
            final FileInputStream fileIn = new FileInputStream("src/main/resources/edu/gu/maze/util/Game.ser");
            in = new ObjectInputStream(fileIn);
            result = (Game) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e){
            result = new Game();
        }
        return result;
    }
    
    public static void saveGame(Game game) {
        try {
            final FileOutputStream fileOut
                    = new FileOutputStream("src/main/resources/edu/gu/maze/util/Game.ser");
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(game);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
