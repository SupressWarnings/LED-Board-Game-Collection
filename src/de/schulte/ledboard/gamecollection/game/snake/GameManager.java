package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.util.Location;
import ledControl.BoardController;

public class GameManager {

    public GameManager(BoardController controller){
        View view = new View(controller);
        Input input = new Input(controller);
        Game game = new Game(view, input);
        game.init();
        game.insertGameObjects(new Snake(new Location((int)(controller.getHeight() / 2), (int)(controller.getWidth() / 2))));
        game.insertGameObjects(new Apple(controller.getWidth(), controller.getHeight()));
        game.gameLoop();
    }
}
