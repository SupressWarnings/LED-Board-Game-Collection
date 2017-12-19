package de.schulte.ledboard.gamecollection.game.snake;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import java.awt.event.KeyEvent;

public class Input {

    private KeyBuffer inputStack;

    public Input(BoardController controller){
        inputStack = controller.getKeyBuffer();
    }

    public char getInput(){
        char direction = 'N';
        KeyEvent input = inputStack.pop();
        if(input != null && input.getID() == KeyEvent.KEY_PRESSED){
            if(input.getKeyCode() == KeyEvent.VK_UP){
                direction = 'U';
            }else if(input.getKeyCode() == KeyEvent.VK_DOWN){
                direction = 'D';
            }else if(input.getKeyCode() == KeyEvent.VK_LEFT) {
                direction = 'L';
            }else if(input.getKeyCode() == KeyEvent.VK_RIGHT){
                direction = 'R';
            }
            inputStack.clear();
        }
        return direction;
    }
}
