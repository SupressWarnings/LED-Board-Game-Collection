package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.util.Location;
import ledControl.BoardController;

public class GameManager {
    public GameManager(BoardController controller){
        View view = new View(controller);
        Input input = new Input(controller);
        Game game = new Game(view, input);
        game.init();
        game.insertGameObject(new Player(new Location(6, 11), game, controller.getWidth(), controller.getHeight() + 1));
        game.insertGameObject(new Enemies(new Location(0, 1), controller.getWidth(), controller.getHeight(), 8, game));
        game.gameLoop();
    }
}
