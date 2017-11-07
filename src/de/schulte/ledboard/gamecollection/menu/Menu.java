package de.schulte.ledboard.gamecollection.menu;

import de.schulte.ledboard.gamecollection.drawable.*;
import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import java.awt.event.KeyEvent;

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

    private KeyBuffer inputControl;

    private int currentGame = 1;

    private final int AMOUNT_GAMES = 1;

    /**
     * Create a new Menu with initializing the graphics.
     *
     * @param controller the controller of the board.
     */
    public Menu(BoardController controller){
        this.controller = controller;
        inputControl = KeyBuffer.getKeyBuffer();
        init();
    }

    /**
     * Draws the graphical elements for the single games.
     */
    private void init(){
        boolean stop = false;
        while(!stop){
            drawMenuScreen();
            KeyEvent input = inputControl.pop();
            if(input != null){
                if(input.getKeyCode() == KeyEvent.VK_DOWN){
                    --currentGame;
                    if(currentGame == 0){
                        currentGame = AMOUNT_GAMES;
                    }
                }else if(input.getKeyCode() == KeyEvent.VK_UP){
                    ++currentGame;
                    if(currentGame > AMOUNT_GAMES){
                        currentGame = 0;
                    }

                }else if(input.getKeyCode() == KeyEvent.VK_ENTER){
                    startGame();
                }else if(input.getKeyCode() == KeyEvent.VK_ESCAPE){
                    stop = true;
                }
                inputControl.clear();
            }
        }
    }

    private void drawMenuScreen(){
        controller.resetColors();
        Arrow down = new Arrow(controller, 1, -1, 0, 11);
        Arrow up = new Arrow(controller, 1, 1, 0, 0);
        down.draw();
        up.draw();
        switch(currentGame){
            case 1:
                drawExample();break;
        }
        controller.updateLedStripe();
    }

    private void startGame(){
        controller.resetColors();
        switch (currentGame){
            case 1:
                startExample();break;
        }
    }

    private void startExample(){
        Cross cross = new Cross(controller, 4, 3, 4, 5);
        cross.draw();
        controller.updateLedStripe();
        controller.sleep(2000);
    }

    private void drawExample(){
        Cross cross = new Cross(controller, 3, 3, 3, 5);
        cross.draw();
    }
}
