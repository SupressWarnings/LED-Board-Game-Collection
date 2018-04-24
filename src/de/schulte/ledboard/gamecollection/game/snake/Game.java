package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.game.game_draft.View;

import java.util.List;

public class Game extends de.schulte.ledboard.gamecollection.game.game_draft.Game {
    public static final int SNAKE = 1;
    public static final int APPLE = 2;

    public Game(View view, Input input, List<GameObject> gameObjects) {
        super(view, input, gameObjects);
    }

    public Game(View view, Input input) {
        super(view, input);
    }
}
