package de.schulte.ledboard.gamecollection.game.snake;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.game.game_draft.View;

import java.util.ArrayList;

public class Game extends de.schulte.ledboard.gamecollection.game.game_draft.Game {
    static final int SNAKE = 1;
    static final int APPLE = 2;

    public Game(View view, Input input, ArrayList<GameObject> gameObjects) {
        super(view, input, gameObjects);
    }

    public Game(View view, Input input) {
        super(view, input);
    }
}
