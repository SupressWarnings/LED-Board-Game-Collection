package de.schulte.ledboard.gamecollection.game.snake;

import ledControl.BoardController;
import ledControl.gui.KeyBuffer;

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
            //put to input

            // ... or not
        }
        return null;
    }
}
