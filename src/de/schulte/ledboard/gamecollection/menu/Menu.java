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
            if(input != null && input.getID() == KeyEvent.KEY_PRESSED){
                int AMOUNT_GAMES = 3;
                if(input.getKeyCode() == KeyEvent.VK_DOWN){
                    --currentGame;
                    if(currentGame == 0){
                        currentGame = AMOUNT_GAMES;
                    }
                }else if(input.getKeyCode() == KeyEvent.VK_UP){
                    ++currentGame;
                    if(currentGame > AMOUNT_GAMES){
                        currentGame = 1;
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
        Arrow down = new Arrow(controller, 1, -1, 0, 11, new int[]{127, 127, 127});
        Arrow up = new Arrow(controller, 1, 1, 0, 0, new int[]{127, 127, 127});
        down.draw();
        up.draw();
        switch(currentGame){
            case 1:
                drawExample();break;
            case 2:
                drawTicTacToe();break;
            case 3:
                drawSnake();break;
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
        Cross cross = new Cross(controller, 4, 3, 4, 5, new int[]{100, 100, 100});
        cross.draw();
        controller.updateLedStripe();
        controller.sleep(2000);
    }

    private void drawExample(){
        Rectangle rect = new Rectangle(controller, 1, 4, 8, 8, new int[]{100, 100, 100});
        rect.draw();
        Cross cross = new Cross(controller, 3, 3, 3, 5, new int[]{127, 127, 127});
        cross.draw();
    }

    private void drawTicTacToe(){
        Rectangle line1 = new Rectangle(controller, 1, 10, 5, 1, new int[]{90, 90, 90});
        Rectangle line2 = new Rectangle(controller, 1, 10, 8, 1, new int[]{90, 90, 90});
        Rectangle line3 = new Rectangle(controller, 10, 1, 2, 4, new int[]{90, 90, 90});
        Rectangle line4 = new Rectangle(controller, 10, 1, 2, 7, new int[]{90, 90, 90});
        Rectangle blue1 = new Rectangle(controller, 2, 2, 6, 5, new int[]{0, 0, 80});
        Rectangle blue2 = new Rectangle(controller, 2, 2, 3, 5, new int[]{0, 0, 80});
        Rectangle red = new Rectangle(controller, 2, 2, 9, 2, new int[]{80, 0, 0});
        blue2.draw();
        blue1.draw();
        line1.draw();
        line2.draw();
        line3.draw();
        line4.draw();
        red.draw();
    }

    private void drawSnake(){
        Rectangle line1 = new Rectangle(controller, 6, 1, 5, 2, new int[]{10, 100, 10});
        Rectangle line2 = new Rectangle(controller, 1, 2, 10, 3, new int[]{10, 100, 10});
        Rectangle line3 = new Rectangle(controller, 1, 6, 8, 4, new int[]{10, 100, 10});
        controller.setColor(9, 4, new int[]{10, 100, 10});
        controller.setColor(7, 9, new int[]{10, 120, 10});
        controller.setColor(6, 7, new int[]{120, 10, 10});
        line1.draw();
        line2.draw();
        line3.draw();
    }
}
