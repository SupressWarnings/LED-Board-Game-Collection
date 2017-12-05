package de.schulte.ledboard.gamecollection;

import de.schulte.ledboard.gamecollection.menu.Menu;
import ledControl.BoardController;

/**
 * First class that starts.
 *
 * @author Constantin Schulte
 * @version 0.1
 */
public class Main {

    /**
     * The BoardController used in the whole application.
     */
    private static BoardController controller = BoardController.getBoardController();

    /**
     * Starts the Menu of the game collection with the controller.
     *
     * @param args - No special arguments are allowed -
     */
    public static void main(String[] args) {
        //controller.addNetworkHost("132.252.250.93");
        new Menu(controller);
    }
}
