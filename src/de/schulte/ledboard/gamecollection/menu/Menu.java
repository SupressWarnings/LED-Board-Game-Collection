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
        Arrow arrow = new Arrow(controller, 1, -1, 0, 11);
        Arrow arrow2 = new Arrow(controller, 1, 1, 0, 0);
        Cross cross = new Cross(controller, 3, 3, 3, 5);
        arrow.draw();
        arrow2.draw();
        cross.draw();
        controller.updateLedStripe();
    }
}
