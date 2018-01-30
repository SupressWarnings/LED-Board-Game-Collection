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
     * The BoardController used in the whole application.
     */
    private BoardController controller;

    /**
     * The KeyBuffer all input goes to.
     */
    private KeyBuffer inputControl;

    /**
     * Representing the game currently showed in the menu.
     */
    private int currentGame = 1;

    /**
     * Create a new Menu with initializing the graphics.
     *
     * @param controller The BoardController used in the whole application.
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
        controller.resetColors();
        controller.updateLedStripe();
    }

    /**
     * Draws the basic Menu and chooses the specific game to show on the screen.
     *
     * TODO switch from hardcoding every menu to a better solution
     */
    private void drawMenuScreen(){
        controller.resetColors();
        Arrow down = new Arrow(controller, 1, -1, 0, 11, new int[]{127, 127, 127});
        Arrow up = new Arrow(controller, 1, 1, 0, 0, new int[]{127, 127, 127});
        down.draw();
        up.draw();
        switch(currentGame){
            case 1:
                de.schulte.ledboard.gamecollection.game.snake.View.drawMenu(controller);break;
            case 2:
                drawSpaceInvader();break;
            case 3:
                drawPong();break;
            case 4:
                drawTicTacToe();break;
        }
        controller.updateLedStripe();
    }

    /**
     * Starts the currently shown game.
     *
     * TODO add games and switch from hardcoding to a better solution.
     */
    private void startGame(){
        controller.resetColors();
        switch (currentGame){
            case 1:
                new de.schulte.ledboard.gamecollection.game.snake.Game(controller);break;
            case 2:
                new de.schulte.ledboard.gamecollection.game.spaceinvader.Game(controller);break;
            case 10000:break;
        }
    }

    /**
     * Draws the TicTacToe menu screen.
     *
     * TODO put to another location like the game package instead of the Menu class.
     */
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

    /**
     * Draws the Pong menu screen.
     *
     * TODO put to another location like the game package instead of the Menu class.
     */
    private void drawPong(){
        Rectangle line1 = new Rectangle(controller, 3, 1, 4, 0, new int[]{10, 10, 120});
        Rectangle line2 = new Rectangle(controller, 4, 1, 8, 1, new int[]{120, 10, 10});
        Rectangle line3 = new Rectangle(controller, 7, 1, 4, 2, new int[]{120, 40, 90});
        Rectangle line4 = new Rectangle(controller, 1, 3, 3, 4, new int[]{120, 120, 120});
        Rectangle line5 = new Rectangle(controller, 1, 3, 11, 6, new int[]{120, 120, 120});
        Rectangle line6 = new Rectangle(controller, 7, 1, 4, 9, new int[]{120, 40, 90});
        controller.setColor(8, 8, new int[]{10, 120, 10});
        line1.draw();
        line2.draw();
        line3.draw();
        line4.draw();
        line5.draw();
        line6.draw();
        controller.setColor(9, 1, new int[]{0, 0, 0});
    }

    private void drawSpaceInvader(){
        Rectangle enemies = new Rectangle(controller, 6, 4, 4, 1, new int[]{0, 127, 0});
        Rectangle deadEnemies = new Rectangle(controller, 3, 1, 6, 4, new int[]{0, 0, 0});
        controller.setColor(5, 11, new int[]{127, 127, 127});
        controller.setColor(6, 8, new int[]{127, 0, 0});
        enemies.draw();
        deadEnemies.draw();
    }
}
