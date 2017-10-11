package de.schulte.ledboard.gamecollection;

import de.schulte.ledboard.gamecollection.menu.Menu;
import ledControl.BoardController;

public class Main {

    private static BoardController controller = BoardController.getBoardController();

    public static void main(String[] args){
        new Menu(controller);
    }
}
