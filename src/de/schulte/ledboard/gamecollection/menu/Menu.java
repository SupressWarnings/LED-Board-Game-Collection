package de.schulte.ledboard.gamecollection.menu;

import de.schulte.ledboard.gamecollection.drawable.*;
import ledControl.BoardController;

/**
 * The graphic representation of the menu.
 *
 * @author Constantin Schulte
 */
public class Menu {

    /**
     * The specific controller of the LED-Board on which the Menu should be represented.
     */
    private BoardController controller;

    private int currentGame = 0;

    private final int AMOUNT_GAMES = 1;

    /**
     * Create a new Menu with initializing the graphics.
     *
     * @param controller the controller of the board.
     */
    public Menu(BoardController controller){
        this.controller = controller;
        init();
    }

    /**
     * Draws the graphical elements for the single games.
     */
    private void init(){
        drawMenuScreen();
    }

    private void drawMenuScreen(){
        controller.resetColors();
        Arrow down = new Arrow(controller, 1, -1, 0, 11);
        Arrow up = new Arrow(controller, 1, 1, 0, 0);
        down.draw();
        up.draw();
        switch(currentGame){
            case 0:
                drawExample();break;
        }
        controller.updateLedStripe();
    }

    private void drawExample(){
        Cross cross = new Cross(controller, 3, 3, 3, 5);
        cross.draw();
    }
}
