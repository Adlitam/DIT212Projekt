package edu.gu.maze.util;

import edu.gu.maze.model.Game;
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
        game.createPlayer(0, "Harry", 0);
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
