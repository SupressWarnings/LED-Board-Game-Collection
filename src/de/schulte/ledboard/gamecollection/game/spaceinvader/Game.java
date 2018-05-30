package de.schulte.ledboard.gamecollection.game.spaceinvader;

import de.schulte.ledboard.gamecollection.game.game_draft.GameObject;
import de.schulte.ledboard.gamecollection.game.game_draft.Input;
import de.schulte.ledboard.gamecollection.game.game_draft.View;

import java.util.ArrayList;

public class Game extends de.schulte.ledboard.gamecollection.game.game_draft.Game {
    public static final int PLAYER = 1;
    public static final int ENEMIES = 2;
    public static final int SHOT = 3;

    public Game(View view, Input input, ArrayList<GameObject> gameObjects) {
        super(view, input, gameObjects);
    }

    public Game(View view, Input input){
        super(view, input);
    }
}
