package edu.gu.maze.util;

import edu.gu.maze.model.Game;
import static edu.gu.maze.util.Constants.MAGE;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author omega
 */
public class SavedInformationHandlerTest {
    
    public SavedInformationHandlerTest() {
    }

    /**
     * Test of retrieveGame method, of class SavedInformationHandler.
     */
    @Test
    public void testRetrieveGame() {
        Game game = new Game();
        game.createPlayer(0, "Harry", MAGE);
        SavedInformationHandler.saveGame(game);
        Game retrieved = SavedInformationHandler.retrieveGame();
    }

    /**
     * Test of saveGame method, of class SavedInformationHandler.
     */
    @Test
    public void testSaveGame() {
    }
    
}
