package de.schulte.ledboard.gamecollection.game.snake;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;

public class Input implements de.schulte.ledboard.gamecollection.game.game_draft.Input {

    private KeyBuffer inputStack;

    Input(BoardController controller){
        inputStack = controller.getKeyBuffer();
    }

    @Override
    public ArrayList<Character> getInput() {
        ArrayList<Character> uniqueInput = new ArrayList<>();
        uniqueInput.add('R');
        uniqueInput.add('L');
        uniqueInput.add('U');
        uniqueInput.add('D');
        ArrayList<Character> input = new ArrayList<>();
        while(inputStack.eventsInBuffer() != 0){
            char inputChar = 'N';
            KeyEvent inputEvent = inputStack.pop();
            if(inputEvent.getID() == KeyEvent.KEY_PRESSED){
                int inputCode = inputEvent.getKeyCode();
                switch (inputCode){
                    case KeyEvent.VK_UP:
                        inputChar = 'U';break;
                    case KeyEvent.VK_DOWN:
                        inputChar = 'D';break;
                    case KeyEvent.VK_LEFT:
                        inputChar = 'L';break;
                    case KeyEvent.VK_RIGHT:
                        inputChar = 'R';break;
                    case KeyEvent.VK_C:
                        inputChar = 'C';break;
                    case KeyEvent.VK_T:
                        inputChar = 'T';break;
                }
                if((inputChar == 'T' || inputChar == 'C') && !input.contains('T') && !input.contains('C')){
                    input.add(inputChar);
                }else if(Collections.disjoint(input, uniqueInput) && uniqueInput.contains(inputChar)){
                    input.add(inputChar);
                }
            }
        }
        return input;
    }
}
