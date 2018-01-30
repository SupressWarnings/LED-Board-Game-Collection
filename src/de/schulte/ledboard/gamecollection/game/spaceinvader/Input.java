package de.schulte.ledboard.gamecollection.game.spaceinvader;

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
            if(input.getKeyCode() == KeyEvent.VK_LEFT) {
                direction = 'L';
            }else if(input.getKeyCode() == KeyEvent.VK_RIGHT){
                direction = 'R';
            }else if(input.getKeyCode() == KeyEvent.VK_SPACE){
                direction = 'S';
            }
            inputStack.clear();
        }
        return direction;
    }
}
