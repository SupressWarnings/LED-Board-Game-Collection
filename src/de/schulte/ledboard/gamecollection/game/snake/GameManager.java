package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.util.Location;
import ledControl.BoardController;

public class GameManager {

    public GameManager(BoardController controller){
        View view = new View(controller);
        Input input = new Input(controller);
        Game game = new Game(view, input);
        game.init();
        Snake snake = new Snake(new Location(controller.getHeight() / 2, controller.getWidth() / 2));
        game.insertGameObjects(snake);
        game.insertGameObjects(new Apple(controller.getWidth(), controller.getHeight()));
        game.gameLoop();
        view.drawScore(snake.getScore());
    }
}
