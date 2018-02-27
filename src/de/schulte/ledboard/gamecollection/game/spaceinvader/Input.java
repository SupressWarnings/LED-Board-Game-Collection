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
        boolean spacePressed = false;
        boolean directionSet = false;
        while(inputStack.eventsInBuffer() != 0 && !(spacePressed && directionSet)){
            KeyEvent input = inputStack.pop();
            if(input != null && input.getID() == KeyEvent.KEY_PRESSED){
                if(!directionSet && input.getKeyCode() == KeyEvent.VK_LEFT) {
                    direction = 'L';
                    directionSet = true;
                }else if(!directionSet && input.getKeyCode() == KeyEvent.VK_RIGHT){
                    direction = 'R';
                    directionSet = true;
                }
                if(!spacePressed && input.getKeyCode() == KeyEvent.VK_SPACE){
                    direction++;
                    spacePressed = true;
                }
            }

        }
        inputStack.clear();
        return direction;
    }
}
