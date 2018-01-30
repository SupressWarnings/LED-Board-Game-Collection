package de.schulte.ledboard.gamecollection.game.snake;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import java.awt.event.KeyEvent;

public class Input {

    private KeyBuffer inputStack;

    Input(BoardController controller){
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
            }else if(input.getKeyCode() == KeyEvent.VK_C){
                direction = 'C';
            }else if(input.getKeyCode() == KeyEvent.VK_1){
                direction = 'T';
            }
            inputStack.clear();
        }
        return direction;
    }
}
