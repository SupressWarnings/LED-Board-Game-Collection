package de.schulte.ledboard.gamecollection.game.game_draft;

import java.util.List;

public interface GameObject {
    public boolean update(List<GameObject> gameObjects, List<Character> input);

    public int getType();
}
