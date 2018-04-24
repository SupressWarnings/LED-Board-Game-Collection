package de.schulte.ledboard.gamecollection.game.game_draft;

import java.util.ArrayList;

public interface GameObject {
    public boolean update(ArrayList<GameObject> gameObjects, ArrayList<Character> input);

    public int getType();
}
